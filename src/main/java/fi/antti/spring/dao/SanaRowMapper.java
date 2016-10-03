package fi.antti.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.antti.spring.bean.Kayttaja;
import fi.antti.spring.bean.Sana;


public class SanaRowMapper implements RowMapper<Sana> {

	public Sana mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sana t = new Sana();
		Kayttaja k = new Kayttaja();
		
		t.setId(rs.getInt("id"));
		k.setNimi(rs.getString("nimi"));
		t.setSana(rs.getString("sana"));
		t.setSeloste(rs.getString("seloste"));
		t.setTimestamp(rs.getString("aika"));
		t.setKayttaja(k);
		
		return t;
	}
}
