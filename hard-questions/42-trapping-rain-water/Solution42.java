class Solution42 {
    public int trap(int[] height) {
        
        if(height.length == 0 || height == null) return 0;
        
        int leftIndex = 1,
        rightIndex = height.length-2,
        leftMax = height[0],
        rightMax = height[height.length-1],
        answer = 0;
        
        while(leftIndex <= rightIndex) {
            if(leftMax < rightMax) {
                int currentHeight = height[leftIndex];
                
                if(currentHeight < leftMax ) {
                    answer += leftMax - currentHeight;
                } else {
                    leftMax = currentHeight;
                }
                
                ++leftIndex;
                
            } else {
                
                int currentHeight = height[rightIndex];
                
                if(currentHeight < rightMax) {
                    answer += rightMax - currentHeight;
                    } else {
                    rightMax = currentHeight;
                }
                
                --rightIndex;
                
            }
        }
        
        return answer;
    }
}