class Solution289 {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0)return;
        
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                getIntermediateStates(board, i, j);
            }
        }
        
        
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == -1) board[i][j] = 1;
                if(board[i][j] == 2) board[i][j] = 0;
            }
        }
        
        
        
    }
    
    public void getIntermediateStates(int[][] board, int x, int y) {
        int liveNeighbors = 0;
//         if (x-1 >= 0) {
//             if(y-1 >= 0 && board[x-1][y-1] > 0) liveNeighbors++;
//             if(board[x-1][y] > 0) liveNeighbors++;
//             if(y+1 < board[0].length && board[x-1][y+1] > 0) liveNeighbors++;
//         }
        
//         if(y-1 >= 0 && board[x][y-1] > 0) liveNeighbors++;
//         if(y+1 < board[0].length && board[x][y+1] > 0) liveNeighbors++;
        
//         if(x+1 < board.length) {
//             if(y-1 >= 0 && board[x+1][y-1] > 0) liveNeighbors++;
            
//             if(board[x+1][y] > 0) liveNeighbors++;
            
//             if(y+1 < board[0].length && board[x+1][y+1] > 0) liveNeighbors++;
//         }
        
        for(int i = x - 1 ; i < x + 2; i++) {
            for(int j = y - 1 ; j < y + 2; j++) {
                // When it's out of range, of it's the current cell itself, ignore
                if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || (i == x && j == y))continue;
                if(board[i][j] > 0) liveNeighbors++;
            }
        }
        
        if(board[x][y] == 0) {
            if(liveNeighbors == 3) board[x][y] = -1;
        } else {
            if(liveNeighbors < 2 || liveNeighbors > 3) board[x][y] = 2;
        }
        
        
    }
}