package model;
// Course.java - Chapter 14, Java 5 version.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;
import java.util.Collection;

import util.DBUtil;

public class Course {
	private int courid;
	private String courname;
	//private double credits;
	private String teaname;
	
	public int getCourid() {
		return courid;
	}
	public void setCourid(int courid) {
		this.courid = courid;
	}
	public String getCourname() {
		return courname;
	}
	public void setCourname(String courname) {
		this.courname = courname;
	}
	public String getTeaname() {
		return teaname;
	}
	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}
	
	
	public void update(Course c) throws SQLException{
		Connection conn=DBUtil.getSqliteConnection();
		PreparedStatement stmt=conn.prepareStatement("updateh course set courid=?,courname=?,teaname=?");
		stmt.setInt(1, c.getCourid());
		stmt.setString(2, c.getCourname());
		stmt.setString(3, c.getTeaname());
		stmt.executeUpdate();
		stmt.close();
		conn.close();

	}

}
	//----------------
	// Constructor(s).
	//----------------
/*
	public Course(String cNo, String cName, double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);

		// Note that we're instantiating empty support Collection(s).

		offeredAsSection = new ArrayList<Section>();
		prerequisites = new ArrayList<Course>();
	}

	//------------------
	// Accessor methods.
	//------------------

	public void setCourseNo(String cNo) {
		courseNo = cNo;
	}
	
	public String getCourseNo() {
		return courseNo;
	}
	
	public void setCourseName(String cName) {
		courseName = cName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCredits(double c) {
		credits = c;
	}
	
	public double getCredits() {
		return credits;
	}
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	public void display() {
		System.out.println("Course Information:");
		System.out.println("\tCourse No.:  " + getCourseNo());
		System.out.println("\tCourse Name:  " + getCourseName());
		System.out.println("\tCredits:  " + getCredits());
		System.out.println("\tPrerequisite Courses:");

		for (Course c : prerequisites) {
			System.out.println("\t\t" + c.toString());
		}

		// Note use of print vs. println in next line of code.

		System.out.print("\tOffered As Section(s):  ");
		for (Section s : offeredAsSection) {
			System.out.print(s.getSectionNo() + " ");
		}

		// Finish with a blank line.

		System.out.println();
	}
	
	@Override
	public String toString() {
		return getCourseNo() + ":  " + getCourseName();
	}

	public void addPrerequisite(Course c) {
		prerequisites.add(c);
	}

	public boolean hasPrerequisites() {
		if (prerequisites.size() > 0) return true;
		else return false;
	}

	public Collection<Course> getPrerequisites() {
		return prerequisites;
	}

	public Section scheduleSection(char day, String time, String room,
				       int capacity) {
		// Create a new Section (note the creative way in
		// which we are assigning a section number) ...

		Section s = new Section(offeredAsSection.size() + 1, 
				day, time, this, room, capacity);
		
		// ... and then remember it!

		addSection(s);
		
		return s;
	}

	public void addSection(Section s) {
		offeredAsSection.add(s);
	}*/

