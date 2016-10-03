package fi.antti.spring.bean;

public class Sana {

	private int id;
	private String sana;
	private String seloste;
	private Kayttaja kayttaja;
	private String timestamp;
	private int kayttaja_id;

	public Sana(int id, String sana, String seloste, Kayttaja kayttaja,
			String timestamp, int kayttaja_id) {
		super();
		this.id = id;
		this.sana = sana;
		this.seloste = seloste;
		this.kayttaja = kayttaja;
		this.timestamp = timestamp;
		this.kayttaja_id = kayttaja_id;
	}

	public Sana() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSana() {
		return sana;
	}

	public void setSana(String sana) {
		this.sana = sana;
	}

	public String getSeloste() {
		return seloste;
	}

	public void setSeloste(String seloste) {
		this.seloste = seloste;
	}

	public Kayttaja getKayttaja() {
		return kayttaja;
	}

	public void setKayttaja(Kayttaja kayttaja) {
		this.kayttaja = kayttaja;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getKayttaja_id() {
		return kayttaja_id;
	}

	public void setKayttaja_id(int kayttaja_id) {
		this.kayttaja_id = kayttaja_id;
	}

	@Override
	public String toString() {
		return "Sana [id=" + id + ", sana=" + sana + ", seloste=" + seloste
				+ ", kayttaja=" + kayttaja + ", timestamp=" + timestamp
				+ ", kayttaja_id=" + kayttaja_id + "]";
	}

}
