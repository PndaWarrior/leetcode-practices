class Solution11 {
    
    public int getWater(int[] height, int start, int end) {
        return Math.min(height[start], height[end]) * (end-start); 
    }
    
    public int maxArea(int[] height) {
        if(height.length == 0 || height == null || height.length == 1) return 0;
        if(height.length == 2 ) return getWater(height, 0, 1);
        int start = 0;
        int end = height.length - 1;
        
        int max = 0;
        
        while(start < end) {
            int currentWater = getWater(height, start, end);
            max = (currentWater > max) ? currentWater : max;
            
            if(height[start] < height[end]) {
                ++start;
            } else {
                --end;
            }
        }
        
        return max;
        
    }
}