package StringBuilder;
/*Remove all spaces from a string using StringBuilder
Input: "Java is awesome"
Output: "Javaisawesome" */

public class Q1_RemoveSpacesFromString {
public static void main(String[] args) {
        
        String input = "Java is awesome";
        StringBuilder sb = new StringBuilder();
        
        for (char ch : input.toCharArray()) {
            if (ch != ' ') {  
                sb.append(ch); 
            }
        }
        
        System.out.println("Output: " + sb.toString());
    }
}