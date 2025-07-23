package com.aurionpro.overloading.test;

import com.aurionpro.overloading.model.AttendanceTracker;

public class AttendanceTrackerTest {
	public static void main(String[] args) {
		String name = "anshika";
	    String[] students = {"Alice", "Bob", "Charlie"};
		AttendanceTracker attendance = new AttendanceTracker();
		System.out.println("-------Attendance Tracker for student -------");
		System.out.println(attendance.markAttendance());
		System.out.println(attendance.markAttendance(name));
		System.out.println("attendance marksed for "+students.length + " students  : ");
		attendance.markAttendance(students);

	}

}
