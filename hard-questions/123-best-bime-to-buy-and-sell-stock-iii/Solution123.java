class Solution123 {
    public int maxProfit(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE,
        minPrice2 = Integer.MAX_VALUE,
        maxProfit1 = 0,
        maxProfit2 = 0;
        
        for(int i = 0; i < prices.length; i++) {
            minPrice1 = Math.min(minPrice1, prices[i]);
            maxProfit1 = Math.max(maxProfit1, prices[i] - minPrice1);
            minPrice2 = Math.min(minPrice2, prices[i] - maxProfit1);
            maxProfit2 = Math.max(maxProfit2, prices[i] - minPrice2);
        }
        
        return maxProfit2;
        
    }
}