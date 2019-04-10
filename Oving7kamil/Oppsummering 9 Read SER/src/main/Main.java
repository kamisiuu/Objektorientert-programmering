package main;

import java.util.ArrayList;

import fileManagement.LesFraFil;
import fileManagement.SkrivTilFil;

public class Main {
	//liste som holder på kurs vi har i systemet
	private static ArrayList<Kurs> kursListe = new ArrayList<>();
	
	//liste som holder på alle studentene i systemet
	private static ArrayList<Student> studentListe = new ArrayList<>();

	public static void main(String[] args) {
		
		// leser inn kursobjekt fra fil
		new LesFraFil("C:\\Users\\Per\\Desktop\\oop\\forelesning 9\\filer\\kurs.ser");
		
		// leser inn studentobjekt fra fil
		new LesFraFil("C:\\Users\\Per\\Desktop\\oop\\forelesning 9\\filer\\student.ser");
				
		// sjekker kurs som har dukket opp i kursListen
		for(Kurs k : kursListe){
			System.out.println(k.getCourseName());
		}
		
		// sjekker studenter som har dukket opp i studentlisten
		for(Student s : studentListe){
			System.out.println(s.getsName() + " " + s.getKursListe().size());
		}
	}
	
	
	// get and set
	public static ArrayList<Kurs> getKursListe() {
		return kursListe;
	}

	public static ArrayList<Student> getStudentListe() {
		return studentListe;
	}

	
	
}
