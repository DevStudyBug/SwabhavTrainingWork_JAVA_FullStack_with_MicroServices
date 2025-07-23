package assignment.day4.model;

public class StudentSubjectMarks {

	
		int subject1 , subject2 , subject3 ;
		
		public StudentSubjectMarks(int subject1 ,int subject2 , int subject3 ) {
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	 }
		public void display() {
			System.out.println("Subject1 "+ subject1 + " Subject2 : "+ subject2 + " Subject3: "+ subject3);
			System.out.println("---------------------------------------------------------------------------");
		}
	}


