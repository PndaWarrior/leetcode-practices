class Solution361 {
    public int maxKilledEnemies(char[][] grid) {
        
        // To solve this using brute force, we would simply go through each cell (which is M*N number of them), and for each, we would simply check loop to through the top and bottom and left and right to see how many enemies we hit.  if M = N then this would take N^3 times
        
        //What we can do is use memoization as a technique for solving this problem, we can have for grids, each one is to save what was the left enemies killed from that cell, and the total number of enemies killed would be the current cell plus the 4 sides.
        
        if (grid.length == 0) return 0;
        
        int[][] left = new int[grid.length][grid[0].length];
        int[][] right = new int[grid.length][grid[0].length];
        int[][] top = new int[grid.length][grid[0].length];
        int[][] bot = new int[grid.length][grid[0].length];
        
        // We loop through the 2d array and initiate the enemy on the top we've encountered.
        
        for (int i = 0; i < top.length; i ++) {
            for (int j = 0; j < top[i].length; j++) {
                // If it's at i == 0, then we are at our base case for this memoization process, simply set it to E = 1 or 0
                if (i == 0) {
                    top[i][j] = (grid[i][j] == 'E') ? 1 : 0;
                } else {
                    
                    if(grid[i][j] == 'W') {
                        // if we see a wall, then we need to simply reset the current item to 0, because explosion cannot reach anything to the top of the wall
                        top[i][j] = 0;                    
                    } else {
                        top[i][j] = (grid[i][j] == 'E') ? top[i - 1][j] + 1 : top[i - 1][j];
                    }
                    
                }
            }
        }
        
        //Repeat for bottom
        for (int i = bot.length - 1; i >= 0; i--) {
            for (int j = 0; j < bot[i].length; j++) {
                if (i == bot.length - 1) {
                    bot[i][j] = (grid[i][j] == 'E') ? 1 : 0;
                } else {
                    if(grid[i][j] == 'W') {
                        bot[i][j] = 0;                    
                    } else {
                        bot[i][j] = (grid[i][j] == 'E') ? bot[i + 1][j] + 1 : bot[i + 1][j];
                    }
                    
                }
            }
        }
        //Repeat for left
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left[i].length; j++) {
                if (j == 0) {
                    left[i][j] = (grid[i][j] == 'E') ? 1 : 0;
                } else {
                    if(grid[i][j] == 'W') {
                        left[i][j] = 0;                    
                    } else {
                        left[i][j] = (grid[i][j] == 'E') ? left[i][j - 1] + 1 : left[i][j - 1];
                    }
                    
                }
            }
        }
        //Repeat for right
        for (int i = 0; i < right.length; i++) {
            for (int j = right[i].length - 1; j >= 0; j--) {
                if (j == right[i].length - 1) {
                    right[i][j] = (grid[i][j] == 'E') ? 1 : 0;
                } else {
                    if(grid[i][j] == 'W') {
                        right[i][j] = 0;                    
                    } else {
                        right[i][j] = (grid[i][j] == 'E') ? right[i][j + 1] + 1 : right[i][j + 1];
                    }
                    
                }
            }
        }
        
        //Then we simply sum them together.
        
        int maxEnemies = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // The problem doesn't state it, but it seems that we can only place a bomb on a tile that's marked as '0'.  So we should only check to drop bombs at location marked as '0'
                if (grid[i][j] == '0') {
                    maxEnemies = Math.max(maxEnemies, left[i][j] + right[i][j] + top[i][j] + bot[i][j]);
                }
                
            }
        }
        
        
        
        
        return maxEnemies;
        
        
    }
}