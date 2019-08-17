import java.util.Arrays;

public class LambdaPractice {
	
	public static void main(String[] args) {
		
//		Reverse a given string, replace all trailing spaces, and the returns string should NOT have multpile spaces between words
//		Example:
//		Given a string : "   Hello!      world!   "
//		return "world! Hello!"
		
		
		
		String question = "   Hello!     world!   you   taihaole   ";
		
		
		//We want to first trim to remove front and back spaces
		
		String trimmed = question.trim();
		System.out.println("Trimed String : " + trimmed);
		
		
		//Then we can split the string into an array separated by spaces
		
		String[] stringArray = trimmed.split(" ");
		
		System.out.println(Arrays.toString(stringArray));
		
		//Then we can load the array in a stream and filter out empty characters in the case where there are multiple spaces between characters
		
		String[] removedSpaces = Arrays.stream(stringArray).filter( s -> {
			return !s.equals("");
			}).toArray(String[]::new);
		
		System.out.println(Arrays.toString(removedSpaces));
		
		
		//Reverse the arrays only if it's bigger than size 1
		if (removedSpaces.length > 1) {
			
			for (int i = 0; i < removedSpaces.length/2; i++) {
				
				String temp = removedSpaces[i];
				
				removedSpaces[i] = removedSpaces[removedSpaces.length - i - 1];
				
				removedSpaces[removedSpaces.length - i - 1] = temp;
				
			}
		}

		System.out.println(Arrays.toString(removedSpaces));
		
		
		String result = String.join(" ", removedSpaces);
		
		System.out.println(result);
		
		
		
		
	}

}
