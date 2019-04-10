package medlemmer;

public class Leverandor {

	private String navn;
	private String epost;
	private String adr;
	private int pnr;
	private String psted;
	private String tlf;
	
	
	//konstroktør med getters og setters 
	public Leverandor(String navn, String epost, String adr, int pnr,
			String psted, String tlf) {
		super();
		this.navn = navn;
		this.epost = epost;
		this.adr = adr;
		this.pnr = pnr;
		this.psted = psted;
		this.tlf = tlf;
	}
	public static void main(String[] args) {
		
	}

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

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		return navn;
	}
	
}
