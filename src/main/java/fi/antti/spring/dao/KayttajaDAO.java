package fi.antti.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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


	

	public List<Kayttaja> haeKaikki() {
		
		String sql = "SELECT t2.id id, t2.nimi nimi, COUNT(kayttaja_id) AS lkm FROM sanat t1 JOIN sana_henkilot t2 ON t2.id = kayttaja_id GROUP BY kayttaja_id ORDER BY lkm DESC";
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		List<Kayttaja> kayttajat = jdbcTemplate.query(sql,mapper);

		return kayttajat;
	}

}
