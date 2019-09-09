import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution353 {
    
    // I need to be able to move the head of the snake as well as add to the end when it eats food.  I would need to use a linkedlist to be able to move front and add to back, specifically a deque.  
    
    //I can use the number for score to keep track of which food index we're on, at score 0 we're at the 0th index of food array
    int[][] food;
    int width;
    int height;
    int score;
    
    Deque<int[]> snake;
    Set<Integer> occupied;
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public Solution353(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.score = 0;
        this.snake = new LinkedList<int[]>();
        this.occupied = new HashSet<Integer>();
        int[] start = new int[]{0,0};
        occupied.add(getSetKey(start));
        snake.offerFirst(start);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        
        //First thing we check when the snake move is whether it hits the wall
        
        int[] snakeHead = snake.peekFirst();
        int[] next = null;
        
        //Determine the next move by the head
        if (direction.equals("U")) {
            next = new int[]{snakeHead[0] - 1, snakeHead[1]};
            
        } else if (direction.equals("D")) {
            next = new int[]{snakeHead[0] + 1, snakeHead[1]};
            
        } else if (direction.equals("R")) {
            next = new int[]{snakeHead[0], snakeHead[1] + 1};
            
        } else if (direction.equals("L")) {
            next = new int[]{snakeHead[0], snakeHead[1] - 1};
            
        }
        
        // Now I need to do a couple of checks, 
        //1. Does it eat food
        //2. Did it hit a wall
        //3. Did it hit itself
        
        // We can check if it hits wall first since that's going to be independent of other checks.
        
        if (next[0] < 0 || next[0] >= this.height || next[1] <0 || next[1] >= this.width) {
            return -1;
        }
        
        //Then we need to check if it east a food, becuase there are two conditions that depends on the food
        // A. if it eats food,then we don't pop the tail because tail don't move, but snake head move
        // B. if it doesn't eat food, then the tail is popped
        // Reason for this two situation is becuase we need to check if the snake would hit its own tail, if there's no food then we should pop the tail first because the snake will move there
        
        int[] tail = null;
        
        if (this.score < this.food.length && next[0] == this.food[score][0] && next[1] == this.food[score][1]) {
            //eats food, so score + 1;
            //Since we ate the food, so tail stays
            this.score++;
        } else {
            //Doesn't eat food so we pop the tail because it will be moved
            tail = snake.pollLast();
            occupied.remove(getSetKey(tail));
        }
        
        //Regardless of eating food, now the next position is the new head position, so we need to check whether that collides with any existing cells.
        if (occupied.contains(getSetKey(next))) {
            return -1;
        }
    
        //Now that we've checked everything, eatting food, hitting wall, hit iteslf.  We can now safely add the head into the deque and continue the game
        snake.offerFirst(next);
        occupied.add(getSetKey(next));
        
        return score;
        
        
    }
    
    private int getSetKey(int[] coordinate) {
        // We need to calculate out a key to store into the occupied set, we can do this by the following
        // given (i, j) coordinate, key = i * heigh tof board + j
        
        return coordinate[0] * this.width + coordinate[1];    
    }
    
    
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */