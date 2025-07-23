package StringBuilder;
/*Remove all digits from a string using StringBuilder
Input: "abc123xyz"
Output: "abcxyz*/
public class Q5_DigitsRemoverFromString {
	public static void main(String[] args) {
		String str = "abc123xyz";
	    StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < str.length(); i++) {
	        if (!Character.isDigit(str.charAt(i))) {
	            sb.append(str.charAt(i));
	        }
	    }
	    System.out.println();
	    System.out.println("Output: " + sb.toString());
	}
	}
	

