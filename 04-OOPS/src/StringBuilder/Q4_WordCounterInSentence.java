package StringBuilder;
/*Count occurrences of a word in a sentence using StringBuilder
Input: "this is this and that is this" */
public class Q4_WordCounterInSentence {
	public static void main(String[] args) {
		String str = "this is this and that is this";
	    String word = "this";
	    int count = 0;

	    String[] words = str.split(" ");

	    for (String w : words) {
	        if (w.equals(word)) {
	            count++;
	        }
	    }

	    System.out.println("Output: " + count);
	
	}
	
}
