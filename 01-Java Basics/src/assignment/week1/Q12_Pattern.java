package assignment.week1;
//12. Print the following pattern:
//1
//12
//123
//1234

public class Q12_Pattern {
	public static void main(String[] args) {
		for (int i =1; i<=4 ;i++) {  //i=2
			for (int j =1; j<= i;j++) { // j = 1,2
				System.out.print(j);
			}
			System.out.println(); 
		}
	}

}
