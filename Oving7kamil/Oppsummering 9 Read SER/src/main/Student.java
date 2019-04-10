package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	
	private static final long serialVersionUID = -7276121719562344048L;
	
	private String studId;
	private String fName;
	private String sName;
	private String adr;
	private int zip;
	private String town;
	private ArrayList<Kurs> kursListe = new ArrayList<>();
	
	// constructor
	public Student(String studId, String fName, String sName, String adr,
			int zip, String town) {
		this.studId = studId;
		this.fName = fName;
		this.sName = sName;
		this.adr = adr;
		this.zip = zip;
		this.town = town;
	}
	
	
	//get and set
	public String getStudId() {
		return studId;
	}
	public void setStudId(String studId) {
		this.studId = studId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public ArrayList<Kurs> getKursListe() {
		return kursListe;
	}

}
