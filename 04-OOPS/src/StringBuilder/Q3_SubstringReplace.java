package StringBuilder;

/*Replace a substring using StringBuilder methods
Replace "bad" with "good" in "This is a bad idea"
*/
public class Q3_SubstringReplace {  //collection try
	public static void main(String[] args) {
		String str = "This is a bad idea";
		String updated = str.replace("bad", "good"); 
		System.out.println("Updated String: " + updated);
	}
}

