class Solution651 {
    public int maxA(int N) {
        //To solve for this using DP, we first need to think about all the cases we have for each state.
        // I will need to have a dp array to remember the last state and simply need to determine how to move to the next state
        
        
        // One thing to note is that, we can simply disregard anything that's before N <= 6, because anything with N <= 6 it's simply just N
        // If N = 0, then it's 0 
        // If N = 1, then it's 1 because we press A once
        // If N = 2, press A twice
        // N = 3, press A thrice
        // N = 4, press A four times, because if we press A once, and go through the three keys to copy and paste, that would only result to 2 A
        // N = 5, press A 5 times, because if we first press twice, then go through three keys to copy and past,tha twould only result to 3 A
        // N = 6, press A 6 times, or if we first press 3 times, and then copy past using three steps, resulting to 6 A
        
        if (N <= 6) return N;
        
        
        int[] dp = new int[N + 1];
        
        for (int i = 0; i < dp.length; i++) {
            
        // The base case for each state is simple, the minimum a any given N is simply press Key 1 N times so let's initialize that first
        
            dp[i] = i;
            
        //Now that we have the base cases settlted, we need to think about how we can move on to the next state
        //given any i, I can move from i-1 by simply cliking one A, or I can move from i - 1 if i - 1 has successfully ctrl-c or ctrl-v
        // The problem is that, we don't know at which point we would be copy and pasting from, at a large N like let's say N = 11, the best solution is to copy when there are 9 As from when N = 7, and then pasting 3 more times to get 27
            //We know that at any given point of time, we have to waste 2 steps to selct all and copy, so what we can do is, check all possible place where we can select all and copy, then the number of times we can past is just the difference from the current location i to the copied location p
            
            //We check j up to i - 3, because at i - 2, there are only enough operation to select and copy, there's not enough operation to also paste, so we can't consider i - 2
            for (int j = 1; j < i - 2; j++) {
                
                //To caluclate out how many times we've pasted, we can simply get the value of As at j, which is just dp[j], times the difference between j and i-2 (keep in mind that we have to waste two steps to select and copy)
                //Note, we have to add dp[j] because that's already printed on the screen, dp[j] * (i - 2 - j) only calculates out the additional As we pasted
                dp[i] = Math.max(dp[i] , dp[j] * (i - 2 - j) + dp[j]);
                
            }
            
            
        }
        
        return dp[N];
        
    }
}