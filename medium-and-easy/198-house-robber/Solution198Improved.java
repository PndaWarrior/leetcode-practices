class Solution198Improved {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int preprevious = nums[0];
        int previous = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int current = Math.max(nums[i] + preprevious, previous);

            int temp = previous;
            previous = current;
            preprevious = temp;

        }

        return previous;

    }

}
