/***********************************************************************
 Program Name: StudentGPAInfo.java
 Programmer's Name: Student Name
 Program Description: This class will get the student object and calculates the gpa
 ***********************************************************************/

import java.text.DecimalFormat;


public class StudentGPAInfo {

	private double gpa;
	private int totalGradedPoints;
	private int numberOfClasses;
	private String studentName;
	
	public StudentGPAInfo(){
		gpa=0;
		totalGradedPoints = 0;
		numberOfClasses=0;
		studentName = "";
	}
	public StudentGPAInfo(String name,int noOfClasses,int totalPoints){
		gpa=0;
		totalGradedPoints = totalPoints;
		studentName = name;
		numberOfClasses = noOfClasses;
	}
	
	public void CalculateGPA(){
		gpa = totalGradedPoints/(numberOfClasses*1.0);
	}
	
	public void Set(String name,int noOfClasses,int totalPoints){
		totalGradedPoints = totalPoints;
		studentName = name;
		numberOfClasses = noOfClasses;
	}
	
	public void displayStudent(){
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("************************************");
		System.out.println("Student Name:" + studentName);
		System.out.println("GPA:" + df.format(gpa));
		System.out.println("Total Graded Points:" + totalGradedPoints);
		System.out.println("Number of Classes:" + numberOfClasses);
		System.out.println("************************************");
		System.out.println();
	}
	
}
