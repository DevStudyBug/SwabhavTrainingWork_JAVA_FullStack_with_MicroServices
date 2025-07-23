package com.aurionpro.overloading.model;
//🔹 9. Attendance Tracker
//Create a class Attendance:
// markAttendance() – marks general attendance
// markAttendance(String name) – marks attendance for one student
// markAttendance(String[] names) – for multiple students
public class AttendanceTracker {
String name;
public String markAttendance() {
	return "Attendence marked! " ;
}
public String  markAttendance(String name) {
//	System.out.println("Attendence mark for student "+ name);
	return "Attendence mark for student name "+ name;
}
public String markAttendance(String[] names) {
	for (String name : names) {
        System.out.println("- " + name);
        }
	return name ;	
}
}
