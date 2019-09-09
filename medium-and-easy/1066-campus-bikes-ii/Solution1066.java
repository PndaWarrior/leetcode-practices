import java.util.HashMap;
import java.util.Map;

class Solution1066 {
    
    
    public static int dist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    
    //One more further optimization we can do.  Since we are using an integer for bikesTakenBitMask, we can simply use an int[] instead of a map for our dp
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        //Final optimization, do we really need to generate the key like that?  since we know that the bikes have length <= 10, then this means we can use the bitmask technique on the bikeTaken itself, instead of having to loop through the bike array to generate the key, we simply use an integer, and the index of the bit corresponds to the index of the bikes taken
        
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        return dfs(workers, bikes, 0, 0, dp);
        
    }
    
    public int dfs(int[][] workers, int[][] bikes, int bikesTakenBitMask, int workerIndex, Map<Integer, Integer> dp) {
        
        if (workerIndex >= workers.length) {
            return 0;
        }
        //if the key is in the dp map, then we don't need to calculate again
        if (dp.containsKey(bikesTakenBitMask)) return dp.get(bikesTakenBitMask);
        
        //Since the ke is not in the dp ap, then we do need to calculate again, so first set a variable to use for calculating min
        int min = Integer.MAX_VALUE;
        
        //For this worker, we have to try to see what the result would be if it took a certain bike, 
        for (int i = 0; i < bikes.length; i++) {
            
            //How do we determine if a bike is taken, consider index 01001, this means bike at index 0 and 3 is taken,  I can't just get the bit index directly, if I want to check whether the bike at index 3 is taken, we can perform an "and" operation between 01001 and 01000, if the result is 0, then the bike is not taken.  In this case, bike 3 is taken.  if we want to check index 2, then we bitwise "and" 01001 and 00100, this result in a 0 so this is a bike that's not taken.
            if ((bikesTakenBitMask & ( 1 << i)) == 0) {
                
                //To set the bit at index where we want to take the bike, let's say at index 2, we bitwise "OR" 01001 and 00100, the result would be 01101, indicating that now bike at index2 has been taken
                bikesTakenBitMask |= (1 << i);
                
                int currentSum = dist(workers[workerIndex], bikes[i]) + dfs(workers, bikes, bikesTakenBitMask, workerIndex + 1, dp);
                min = Math.min(currentSum, min);
                
                //To unset the ith bit, we can bitwise "and" 01101 and 11011, this will result in 01001, 
                bikesTakenBitMask &= ~(1 << i);
            }
            
        }
        dp.put(bikesTakenBitMask, min);
        
        return min;
        
    }
    
    
    
    
    //---------------------------------------------------------------------------------------------------------------------------
    //First Attempt to brute force using all possible permutations and without any memoization
    // The brute force way takes too long because we would need to permutate all possible combinations, so let's say for worker 0, if it takes bike 0, we would need to calculate out the permutation of if worker 1 took bike 1, or bike 2, or bike 3, or bike 4 and so on, then when we check the permutation of when worker 0 take bike 1, then we have to check again the permutation of worker 1 took bike 2 or bike 3 or bike 4 and so on
    
    public int assignBikesFirstAttempt(int[][] workers, int[][] bikes) {
        // The brute force way to take care of this porblem is to go through all Possible permuattions of worker bikes pair, and which ever one is the smallest use that.  
        // The best way to do this is dfs, where we check for each worker (depth), what's the permutation if he chooses the first bike, and what's the permutation if he chooses the second bike and so on,
        //Then for the next worker (next depth level), what's the sum distance if he choose another bike and so on.
        boolean[] bikeTaken = new boolean[bikes.length];
        return dfsFirstAttempt(workers, bikes, bikeTaken, 0, 0, Integer.MAX_VALUE);
        
    }
    
    //Let's first define a dfs function to search through all permutations of the worker and bike pair
    //bikeTaken will tell us at that point in time, the bike has been taken so the next iteration cannot take the bike
    //sumDistance will be used to calculate out the total sum of a particular permutation
    //workerIndex will tell me at which worker is my current permutation
    public int dfsFirstAttempt(int[][] workers, int[][] bikes, boolean[] bikeTaken, int sumDistance, int workerIndex, int currentMax) {
        
        if (workerIndex >= workers.length) {
            return sumDistance;
        }
        
        for (int i = 0; i < bikes.length; i++) {
            if (!bikeTaken[i]) {
                bikeTaken[i] = true;
                int currentSum = dfsFirstAttempt(workers, bikes, bikeTaken, sumDistance + dist(workers[workerIndex], bikes[i]), workerIndex + 1, currentMax);
                currentMax = Math.min(currentSum, currentMax);
                bikeTaken[i] = false;
            }
        }
        
        return currentMax;
        
    }
    
    
    
    //---------------------------------------------------------------------------------------------------------------------------
    
    public int assignBikesSecondAttempt(int[][] workers, int[][] bikes) {
        // Let's optimize this using memoization technique.
        // What do we need to memorize?  
        
        // If we know that worker 0 have to take bike 1, then the calculation for worker 1 is min(dp[0][0] + worker1 taking from bike[1 -> n])
        //So we have to create a hashmap, and we will compute a key to determine whether a specific permutation has been calculated, for example if worker 0 took bike 1, and worker 1 took bike 0, that would be its own unique key, and that key has its own distance value
        //We will use a bitmask key, so for example 001 means that bike at0 is taken, and bike at 1 and 2 are not taken yet
        
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        boolean[] bikeTaken = new boolean[bikes.length];
        return dfsSecondAttempt(workers, bikes, bikeTaken, 0, dp);
        
    }
    
    public int dfsSecondAttempt(int[][] workers, int[][] bikes, boolean[] bikeTaken, int workerIndex, Map<Integer, Integer> dp) {
        
        if (workerIndex >= workers.length) {
            return 0;
        }
        //Check for the key generated from bikeTaken
        int key = createKey(bikeTaken);
        //if the key is in the dp map, then we don't need to calculate again
        if (dp.containsKey(key)) return dp.get(key);
        
        //Since the ke is not in the dp ap, then we do need to calculate again, so first set a variable to use for calculating min
        int min = Integer.MAX_VALUE;
        
        //For this worker, we have to try to see what the result would be if it took a certain bike, 
        for (int i = 0; i < bikes.length; i++) {
            
            if (!bikeTaken[i]) {
                bikeTaken[i] = true;
                
                int currentSum = dist(workers[workerIndex], bikes[i]) + dfsSecondAttempt(workers, bikes, bikeTaken, workerIndex + 1, dp);
                min = Math.min(currentSum, min);
                
                bikeTaken[i] = false;
            }
            
        }
        dp.put(key, min);
        
        return min;
        
    }
    
    public static int createKey(boolean[] bikeTaken) {
        int key = 0;
        for (int i = 0; i < bikeTaken.length; i++) {
            //For each bikeTaken, the bit corresponding to the bike taken index will be 1, others will be 0
            if (bikeTaken[i]) key |= (1 << i);
        }
        return key;
    }
    
    
    
    
}