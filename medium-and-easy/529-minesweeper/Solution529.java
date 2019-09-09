import java.util.LinkedList;
import java.util.Queue;

class Solution529 {
    public char[][] updateBoard(char[][] board, int[] click) {
     
        //This can be done in either DFS or BFs, I can explain how to search using both but I'm going to use BFS for this particular problem because it seems a bit easier to implement for this particular problem
        
        bfs(board, click);
        
        return board;
    }
    
    public void bfs(char[][] board, int[] click) {
        
        // First let's take care of the current location, since this is not related to any of our children cells
        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return;
            
        } else {
            
            Queue<int[]> que = new LinkedList<int[]>();
            
            //We need to add the current item into our queue and start our bfs, 
            // We will first check any adjacent item to see what character is it, if it's an M, then we simply need to increment the count we show for current item
            // If it's an E, then we need to add the item into our que
            // If it's a B or any digit, we simply ignore
            que.add(click);
            
            while(!que.isEmpty()) {
                
                int[] current = que.poll();
                
                if (getChar(board,current) != 'E') {
                    continue;
                }
                
                
                int row = current[0];
                int col = current[1];
                
                int[] topLeft = new int[]{row - 1, col - 1},
                top = new int[]{row - 1, col},
                topRight = new int[]{row - 1, col + 1},
                left = new int[]{row, col - 1},
                right = new int[]{row, col + 1},
                botLeft = new int[]{row + 1, col - 1},
                bot = new int[]{row + 1, col},
                botRight = new int[]{row + 1, col + 1};
                
                // Now that we've gotten all the characters ajacent to our current item, we need to count the mines, because if my current has any mines around me, no item should be added to the que.
                
                int mines = 0;
                if (getChar(board, topLeft) == 'M') mines++;
                if (getChar(board, top) == 'M') mines++;
                if (getChar(board, topRight) == 'M') mines++;
                if (getChar(board, left) == 'M') mines++;
                if (getChar(board, right) == 'M') mines++;
                if (getChar(board, botLeft) == 'M') mines++;
                if (getChar(board, bot) == 'M') mines++;
                if (getChar(board, botRight) == 'M') mines++;
                
                if (mines == 0) {
                    board[row][col] = 'B';
                    if (getChar(board, topLeft) == 'E') que.offer(topLeft);
                    if (getChar(board, top) == 'E') que.offer(top);
                    if (getChar(board, topRight) == 'E') que.offer(topRight);
                    if (getChar(board, left) == 'E') que.offer(left);
                    if (getChar(board, right) == 'E') que.offer(right);
                    if (getChar(board, botLeft) == 'E') que.offer(botLeft);
                    if (getChar(board, bot) == 'E') que.offer(bot);
                    if (getChar(board, botRight) == 'E') que.offer(botRight);
                } else {
                //If we find a mine we need to store this character in our board.  But we need to offset it by the character '0'
                    board[row][col] = (char)(mines + '0');
                }
                
                
            }
            
            
            
        }
        
    }
    
    //Helper function to help me get the character from the board, if the character is outside of the board then we use '~' to indicate that.
    public char getChar(char[][] board, int[] current) {
        
        if ( current[0] >= 0 && current[0] < board.length && current[1] >= 0 && current[1] < board[0].length) {
            return board[current[0]][current[1]];
        } 
        
        return '~';
    }
    
    
}