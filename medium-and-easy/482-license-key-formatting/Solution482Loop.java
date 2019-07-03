
public class Solution482Loop {
	public String licenseKeyFormatting(String S, int K) {
	        
	        String answer = "";
	        int count = 0;
	        
	        for (int i = S.length() - 1; i >= 0; i--) {
	            if (S.charAt(i) != '-') { 
	                if (count + 1 < K) {
	                    answer = Character.toUpperCase(S.charAt(i)) + answer;
	                    count++;
	                } else {
	                    answer = "-" + Character.toUpperCase(S.charAt(i)) + answer;
	                    count = 0;
	                }
	            }
	        }
	        
	        if(answer.length() != 0 && answer.charAt(0) == '-') answer = answer.substring(1, answer.length());
	        
	        return answer;
	        
	    }
}
