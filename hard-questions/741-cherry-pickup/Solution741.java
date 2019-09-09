class Solution741 {
    
    //Following the beliow thought, we can optimize this solution a bit using a trick
    // Instead of considering the 4d array dp[row1][col1][row2][col2] as the max amount of cherries to be picked up at row1, col1, row2, col2, position, we can think about it by the amount of steps the have taken.
    
    //So to get to the bottom, person 1 must have moved right n times, and moved down n times, person 2 must have moved right n times and moved down n times
    //Also, at each point of time, since we are moving both people at the same time, then that means at each point, the amount of moves by person 1 must be equal to amoutn of moves by person 2.  So x1 + y1 = x2 + y2.  Using this formula, we can calculate out that y2 = x1 + y1 - x2.  Since we can calculate out where the second person is by the other 3 formula, we can reduce this from a N^4 to N^3 times
    
    public int cherryPickup(int[][] grid) {
        int length = grid.length;
        Integer[][][] dp =  new Integer[length + 1][length + 1][length + 1];
        return Math.max(0, searchMaxOptimal(grid, length, 1, 1, 1, dp));
    }
    
    public int searchMaxOptimal(int[][] grid, int gridLength, int x1, int y1, int x2, Integer[][][] dp) {
               
        //Calculate out how many steps to the right person 2 has taken
        int y2 = x1 + y1 - x2;
        
        //Same idea as before, first check to see if we're out of bounds 
        if ( x1 > gridLength || y1 > gridLength || x2 > gridLength || y2 > gridLength || y2 < 1 || grid[x1-1][y1-1] == -1 || grid[x2-1][y2-1] == -1) {
            return Integer.MIN_VALUE;
        }
        
        if (x1 == gridLength && y1 == gridLength) {
            return grid[x1-1][y1-1];
        }
        
        if (x2 == gridLength && y2 == gridLength) {
            return grid[x2-1][y2-1];
        }
        
        //memoization, if we've already visited, then don't calculate again
        if(dp[x1][y1][x2] != null) {
            return dp[x1][y1][x2];
        }
        
        int cherries = 0;
        
        if (x1 == x2 && y1 == y2 && grid[x1-1][y1-1] == 1) {
            cherries = 1;
        } else {
            cherries = grid[x1-1][y1-1] + grid[x2-1][y2-1];
        }
        
        cherries += Math.max(
            Math.max(
                searchMaxOptimal(grid, gridLength, x1 + 1, y1, x2 + 1, dp),
                searchMaxOptimal(grid, gridLength, x1 + 1, y1, x2, dp)
            ),
            Math.max(
                searchMaxOptimal(grid, gridLength, x1, y1 + 1, x2 + 1, dp),
                searchMaxOptimal(grid, gridLength, x1, y1 + 1, x2, dp)
            )
        );
        
        dp[x1][y1][x2] = new Integer(cherries);
        
        return dp[x1][y1][x2];
    }
    
    
    
    //To solve this problem, we need to realize a couple of details
    
    // 1, the problem describes this as two pass through, once going from 0, 0 to n-1,n-1, and once from n-1, n-1 to 0.  
    //However, if we do use the greedy approach for both pass throughs we won't get the optimization of cherries pick up, consider the below case
    
    // 0100
    // 0100
    // 0101
    // 1100
    // 0111
    
    // If we follow the greedy two pass through solution, we would follow the rought to pick up all the 1s in the middle and bottom, and then on the second pass through, there are 1 at either end of the grid, there's no way to pick up all cherries.  However, it's possible to pick up all cherries.
    
    //So to solve this problem using DP, we need to have a GLOBAL maximum, not LOCAL maximum per run through.
    
    //To get the GLOBAL max, we need to consider another case, that although we are asked to do two pass through, one from front and one from back, but in reality, the second pass through from n-1,n-1 to 0,0, is the same as if we go from 0,0 to n-1,n-1.  This tells us that the two pass through can both be from the front.  Then to find the global max, we will just need to consider what happens when both people move at the same time, for each cell there are only 4 possible options, person 1 move right, person 2 move right, or person 1 move right, person 2 move down, or person 1 move down and person 2 move right, or person 1 move down and person 2 move down.
    
    // So our DP function need to consider that for each option, what's the maximum if the two people move in that cell.  Our DP functio needs to have 4 D, dp[row1][col1][row2][col2], which is to detemine if person 1 is on row1 col1, and person 2 is on row2 col2, what's the maximum amount of chrries we can obtain
    
    // Consider case
    // 011
    // 110
    // 011
    //Starting from 0 0, the maximum of cherries to pick up for dp[0][0][0][0] is the max of the 4 options, and then we see that the max of that is person 1 move right and person 2 move down, then the max of that is whether in those two celll, what's the move option and the max out of them, then we see the next best option is person 1 move right and person 2 move right, if becasue if person 1 move down and person 2 move right, then they can only pick up 1 cherry.
    
    public int cherryPickupNotOptimal(int[][] grid) {
        int length = grid.length;
        return Math.max(0, searchMax(grid, length, 0,0,0,0, new Integer[length][length][length][length]));
    }
    
    public int searchMax(int[][] grid, int gridLength, int row1, int col1, int row2, int col2, Integer[][][][] dp) {
        
        // base case : Check tosee if we hit a boundary or if we landed on a -1
        if (row1 >= gridLength || col1 >= gridLength || row2 >= gridLength || col2 >= gridLength || grid[row1][col1] == -1 || grid[row2][col2] == -1) {
            //Return the min value to indicate we shouldn't move this way.  We can assume there will be at least 1 good path, at worse case of that path is 0, so when we see an option with Integer.MIN_VALUE, it will definitely be smaller than 0 so we won't choose this option.
            return Integer.MIN_VALUE;
        }
        
        //memoization, if we've already visited, then don't calculate again
        if(dp[row1][col1][row2][col2] != null) {
            return dp[row1][col1][row2][col2];
        }
        
        //Then check another base case, what should we do when we reach the end?  
        // when we're right about to move to the end, consider the possible cases, both people are to the left of the end, both people are to the top of the end, and one person is at the top and one person is to the left.  In these 3 cases, we would need to consider the 4 different possible moves again, in some cases, one person will movec to the end, and the other will move to the end.  And there are some cases that both people would move to the end.  We simply need to check if any one person move to the end, if so, then return the end of the grid.  Doing so we will make sure we only return 1 cherry in the case that both people move to the end.
        
        if (row1 == gridLength - 1 && col1 == gridLength - 1) {
            return grid[row1][col1];
        }
        
        if (row2 == gridLength - 1 && col2 == gridLength - 1) {
            return grid[row2][col2];
        }
        
        //Now we need to check what's the amount of cherries we can pick up, if both people are on the same space, we can only consider 1 cherry if it's there
        
        int cherries = 0;
        
        if (row1 == row2 && col1 == col2 && grid[row1][col1] == 1) {
            cherries = 1;
        } else {
            cherries = grid[row1][col1] + grid[row2][col2];
        }
        
        cherries += Math.max(
            Math.max(searchMax(grid, gridLength, row1 + 1, col1, row2 + 1, col2, dp),
                    searchMax(grid, gridLength, row1 + 1, col1, row2, col2 + 1, dp)),
            Math.max(searchMax(grid, gridLength, row1, col1 + 1, row2 + 1, col2, dp),
                    searchMax(grid, gridLength, row1, col1 + 1, row2, col2 + 1, dp))
        );
        
        dp[row1][col1][row2][col2] = new Integer(cherries);
        
        return dp[row1][col1][row2][col2];
        
    }
}