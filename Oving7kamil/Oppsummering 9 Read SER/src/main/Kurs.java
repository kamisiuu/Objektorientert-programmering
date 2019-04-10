package main;

import java.io.Serializable;

public class Kurs implements Serializable{
	
	private static final long serialVersionUID = 2859425363950800997L;
	
	private String courseID;
	private String courseName;
	
	// constructor
	public Kurs(String courseID, String courseName) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
	}
	
	
	//get and set
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
