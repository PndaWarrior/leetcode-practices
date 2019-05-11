import java.util.Arrays;

class Solution188 {
    public int maxProfit(int k, int[] prices) {
        //if k >= prices.lenght/2, that means we can use as many transactions as we want on prices, so this question will just become the number 2 follow up, find profit if we can use as many transactions as we want.
        if(k >= prices.length/2) return quickSolve(prices);
        
        int n = prices.length;
        int[] minPrice = new int[k+1];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        int[] maxProfit = new int[k+1];
        Arrays.fill(maxProfit, 0);
        
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                minPrice[j] = Math.min(minPrice[j], prices[i] - maxProfit[j-1]);
                maxProfit[j] = Math.max(maxProfit[j], prices[i] - minPrice[j]);
                
            }
        }
        
        return maxProfit[k];
        
    }
    
    public int quickSolve(int[] prices){
        int answer = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                answer += prices[i] - prices[i-1];
            }
        }
        return answer;
    }
}