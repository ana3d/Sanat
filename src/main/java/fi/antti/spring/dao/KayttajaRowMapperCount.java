package fi.antti.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.antti.spring.bean.Kayttaja;

public class KayttajaRowMapperCount implements RowMapper<Kayttaja> {

	public Kayttaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kayttaja t = new Kayttaja();
		
		t.setId(rs.getInt("id"));
		t.setNimi(rs.getString("nimi"));
		t.setSana_maara(rs.getInt("lkm"));
		
		return t;
	}
}
