package medlemmer;

import java.io.Serializable;

public class Leverandor implements Serializable {
	
	/* Her defineres alle typer og variabler */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String navn;
	private String epost;
	private String adr;
	private int pnr;
	private String psted;
	private int tlf;
	
	
	/* Her bli det dklarert Getters og setters */
	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getEpost() {
		return epost;
	}
	public void setEpost(String epost) {
		this.epost = epost;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public String getPsted() {
		return psted;
	}
	public void setPsted(String psted) {
		this.psted = psted;
	}
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	
	
	//override
	public String toString(){
	return navn;
	}
	
	/*  */
	
	/* Her er constructor til Levrandor*/
	public Leverandor(String navn, String epost, String adr, int pnr,
			String psted, int tlf) {
		super();
		this.navn = navn;
		this.epost = epost;
		this.adr = adr;
		this.pnr = pnr;
		this.psted = psted;
		this.tlf = tlf;
	}

}
