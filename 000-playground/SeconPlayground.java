import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeconPlayground {
	
	public static void main(String[] args) {
		String temp = "asdf\nasdf\n";
		temp.length();
		
//		String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//		
//		Arrays.sort(numbers);
//		
//		for(int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
		
		String intCast = Integer.toString(0);
		
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		
		String [] arr=input.split("\n");
        int [] lens= new int[arr.length];
        
        for(String s: arr) {
        	int lastBackT= s.lastIndexOf("\t");
        	System.out.println(s);
        	System.out.println(lastBackT);
        }
		
		
		
	}

}
