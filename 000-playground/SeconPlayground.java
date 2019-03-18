import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeconPlayground {
	
	public static void main(String[] args) {
		String temp = "123";
		
		StringBuilder temp3 = new StringBuilder();
		temp3.append(temp.charAt(0));
		
		String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		Arrays.sort(numbers);
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		
		
	}

}
