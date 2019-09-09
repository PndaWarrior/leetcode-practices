class Solution238 {
    
    public int[] productExceptSelf(int[] nums) {
        //To optimize for the space, we can consider only needing one array, which is the answer array, we will use the answer array to store the results of one of the left, or right array, then we can simply use a variable to keep track of accmulated product of the other.
        
        int[] answer = new int[nums.length];
        //Dont' need to consider the first element, because first element will be all the products of the items to the right
        answer[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }
        
        int rightProduct = 1;
        
        //Don't need to consider the last element, because the last element is going to be all the items product to the left, which we already got when we created the original array.
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct *= nums[i+1];
            answer[i] = answer[i] * rightProduct;
        }
        
        return answer;
        
    }
    
    public int[] productExceptSelfNotOptimal(int[] nums) {
        
        // This problem is essentially an advanced of the sum version of this/
        
        // Normally in sum arrays, we can loop through once to find the accmulative sum and then use that to calculate any sum of any interval i andj by simply subtracting accumsum[i] - accumsum[j]
        
        // This product of array except self could've been solved if we simply loop through the array once to get the total product and the divide any number by itself to get the product without itself.  HOWEVER, we can't use division in this problem.
        
        // We can though, however, by utiizing the same idea as accumulative sum, but instead think about the problem as two pieces.  If we can keep an accmulative product from the left up to index i, and also an accmulative product from the right up to index i, then we can simply multiply the left accmulative product and right accumulative product to get the product of array itself that particular index.
        int N = nums.length;
        int[] leftArray = new int[N];
        int[] rightArray = new int[N];
        int[] answer = new int[N];
        
        // Example : Array       [ 1,  2,  3, 4]
        //          Left Array [1, 1,  1,  2, 6]
        // .        Right Array  [ 24, 12, 4, 1, 1]
        // To get the product of array except any index i, we would just use leftArray[i+1] * rightArray[i]
        
        leftArray[0] = 1;
        rightArray[N-1] = 1;
        
        for (int i = 1, j = N - 2; i < N; i++, j--) {
            leftArray[i] = leftArray[i-1] * nums[i-1];
            rightArray[j] = rightArray[j+1] * nums[j+1];
        }

        for (int i = 0; i < N; i++) {
            answer[i] = leftArray[i] * rightArray[i];
        }
        
        
        return answer;
    }
}