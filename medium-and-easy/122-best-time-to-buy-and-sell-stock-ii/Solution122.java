class Solution122 {
    public int maxProfit(int[] prices) {
        if(prices == null ||prices.length == 0 || prices.length == 1) return 0;
        int answer = 0;
        
        for(int i = 0; i < prices.length-1; i++) {
            if(prices[i+1] > prices[i]) {
                answer += prices[i+1] - prices[i];
            }
        }
        
        return answer;
    }
}