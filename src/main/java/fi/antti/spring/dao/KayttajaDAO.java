package fi.antti.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.antti.spring.bean.Kayttaja;

@Repository
public class KayttajaDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Kayttaja> haeKaikkiPisteet() {
		
		String sql = "SELECT t2.id id, t2.nimi nimi, COUNT(kayttaja_id) AS lkm FROM sanat t1 JOIN sana_henkilot t2 ON t2.id = kayttaja_id GROUP BY kayttaja_id ORDER BY lkm DESC";
		RowMapper<Kayttaja> mapper = new KayttajaRowMapperCount();
		List<Kayttaja> kayttajat = jdbcTemplate.query(sql,mapper);

		return kayttajat;
	}
	
	public List<Kayttaja> haeKaikkiKayttajat() {
		
		String sql = "SELECT * FROM sana_henkilot;";
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		List<Kayttaja> kayttajat = jdbcTemplate.query(sql,mapper);

		return kayttajat;
	}
	

	public void talleta(Kayttaja k) {
		final String sql = "insert into sana_henkilot (nimi) values(?)";
		
		//anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		//jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä. 
		final String nimi = k.getNimi();
		//jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
	    
		//suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
	    	            ps.setString(1, nimi);
	    	            return ps;
	    	        }
	    	    }, idHolder);
	    
		//tallennetaan id takaisin beaniin, koska
		//kutsujalla pitäisi olla viittaus samaiseen olioon
	    k.setId(idHolder.getKey().intValue());

	}
	
	
	
}
