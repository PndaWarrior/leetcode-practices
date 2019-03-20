import java.util.Arrays;

public class RunSolution760 {
	public static void main(String[] args) {
		Solution760 sol = new Solution760();
		int[] A = {12,12,28,46,32,50,12};
		int[] B = {50,12,12,12,32,46,28};
		
		System.out.println(Arrays.toString(sol.anagramMappings(A, B)));
	}

}
