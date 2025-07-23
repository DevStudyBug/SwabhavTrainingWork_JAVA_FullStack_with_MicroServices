package StringBuilder;
/*Check if two strings are reverses of each other using StringBuilder
Input: "hello" and "olleh"
Output: Yes */
public class Q2_StringReversalCheck {
	 public static void main(String[] args) {
	        String str1 = "hello";
	        String str2 = "olleh";

	        StringBuilder sb = new StringBuilder(str2);
	        sb.reverse();

	        if (str1.equals(sb.toString())) {
	            System.out.println("Output: Yes");
	        } else {
	            System.out.println("Output: No");
	        }
	    }
}
