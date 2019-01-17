import java.util.Arrays;

public class RunSolution406 {
	public static void main(String[] args) {
		Solution406 sol = new Solution406();
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		printArrays(people);
		
		sol.reconstructQueue(people);
		
		printArrays(people);
	}
	
	public static void printArrays(int[][] people) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for(int[] person: people) {
			sb.append(Arrays.toString(person));
			sb.append(", ");
		}
		sb.delete(sb.length()-3, sb.length());
		sb.append("}");
		System.out.println(sb.toString());
	}

}
