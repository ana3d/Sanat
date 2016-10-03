package fi.antti.spring.bean;

public class Kayttaja {

	private int id;
	private String nimi;
	private int sana_maara;

	public Kayttaja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kayttaja(int id, String nimi, int sana_maara) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.sana_maara = sana_maara;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public int getSana_maara() {
		return sana_maara;
	}

	public void setSana_maara(int sana_maara) {
		this.sana_maara = sana_maara;
	}

	@Override
	public String toString() {
		return "Kayttaja [id=" + id + ", nimi=" + nimi + ", sana_maara="
				+ sana_maara + "]";
	}

}
