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

import fi.antti.spring.bean.Sana;

@Repository
public class SanaDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//
	
	
	/**
	 * Tallettaa parametrina annetun henkilön tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Sana s) {
		

		final String sql = "insert into sanat (aika, sana, seloste, kayttaja_id) values(now(),?,?,?)";
		final String sana = s.getSana();
		final String seloste = s.getSeloste();
		final int kayttaja_id = s.getKayttaja_id();
		//anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		//jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä. 
		//jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
	    
		//suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
	    	            ps.setString(1, sana);
	    	            ps.setString(2, seloste);
	    	            ps.setInt(3, kayttaja_id);
	    	            return ps;
	    	        }
	    	    }, idHolder);
	    
		//tallennetaan id takaisin beaniin, koska
		//kutsujalla pitäisi olla viittaus samaiseen olioon
	    s.setId(idHolder.getKey().intValue());

	}

	public List<Sana> haeKaikki() {

		String sql = "SELECT t1.id, aika, sana, seloste, t2.nimi nimi FROM sanat t1 JOIN sana_henkilot t2 ON kayttaja_id = t2.id";
		RowMapper<Sana> mapper = new SanaRowMapper();
		List<Sana> sanat = jdbcTemplate.query(sql, mapper);

		return sanat;
	}

}
