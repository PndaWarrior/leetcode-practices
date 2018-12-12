import java.util.Arrays;

public class RunSolution1 {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 13;
		
		Solution1 solution = new Solution1();
		
		System.out.println(Arrays.toString(solution.twoSum(nums, target)));
		
		
	}
}
