/***********************************************************************
 Program Name: GPATest.java
 Programmer's Name: Student Name
 Program Description: This class will test the StudentGPAInfo class.
 ***********************************************************************/

public class GPATest {

	public static void main(String[] args) {
		StudentGPAInfo student1 = new StudentGPAInfo("Student 1", 13, 87);
		StudentGPAInfo student2 = new StudentGPAInfo();
		student2.Set("Student2", 40, 465);
		student1.CalculateGPA();
		student2.CalculateGPA();
		student1.displayStudent();
		student2.displayStudent();
	}

}
