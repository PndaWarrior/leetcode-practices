class Solution79 {
    public boolean exist(char[][] board, String word) {
        //We should be able to solve this using DFS and backtracking
        //The idea is that, we will scan through the grid and find the startig string, then we will recursively call all the characters adjacent to the curret character and see if they are also mathes for the next character
        
        //Problem is though we will need to keep track of which character we have already visited, so we will need to keep another 2d arrahy of booleans called visited, when we visit a node we will set that item as visited, but when we backtrack, we will unset the visited item .
        
        if (board.length == 0) return false;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                
                //Only start dfs if we found the character that matches char at string index 0
                if ( board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, 0, visited, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int index, boolean[][] visited, int row, int col) {
        
        //Let's think about what's my base case, if we ever get to an index that's over the length of the word, then we return true, because that means previously we've see all the matched character.
        if (word.length() <= index) {
            return true;
        }
        
        //Another base case, if we try to check outside of our boundary, we should return false, if the current word is visited, return false, and if the current word doesnt match up to the character return false
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || word.charAt(index) != board[row][col]) return false;
        
        //Then since we passed all the above case, then we found a match, simply continue our dfs with all the adjacent characters
        visited[row][col] = true;
        
        boolean answer = dfs(board, word, index + 1, visited, row-1, col) ||
            dfs(board, word, index + 1, visited, row+1, col) ||
            dfs(board, word, index + 1, visited, row, col-1) ||
            dfs(board, word, index + 1, visited, row, col+1);
        
        //Unset the visited cell, so that later cmoputation can reuse that character.
        visited[row][col] = false;
        
        
        return answer;
        
    }
}