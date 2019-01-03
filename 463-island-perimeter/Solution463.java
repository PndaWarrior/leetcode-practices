class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        
        for ( int y = 0; y < grid.length; y++) {
            for ( int x = 0; x < grid[y].length; x++) {
                if(grid[y][x] == 1) {
                    if( x - 1 < 0 || grid[y][x-1] == 0) {
                        result++;
                    }
                    if( x + 1 == grid[y].length || grid[y][x+1] == 0) {
                        result ++;
                    }
                    if( y - 1 < 0 || grid[y-1][x] == 0) {
                        result++;
                    } 
                    if( y + 1 == grid.length || grid[y+1][x] == 0) {
                        result ++;
                    } 
                }
            }
        }
        return result;
    }
}