import java.util.Arrays;

public class RunSolution832 {
	
	public static void main(String[] args) {
		Solution832 sol = new Solution832();
		
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};

		for (int[] row : A) {
			System.out.print('[' + Arrays.toString(row) + ',');
		}
		System.out.print(']');
		
		System.out.println();
		
		
		A = sol.flipAndInvertImage(A);
		
		for (int[] row : A) {
			System.out.print('[' + Arrays.toString(row) + ',');
		}
		System.out.print(']');
		
		
		
	}

}
