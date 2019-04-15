import java.util.Comparator;
import java.util.PriorityQueue;

class Solution407 {
    
    class Node {
        int x = 0;
        int y = 0;
        int val = 0;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int calculateRainUnit(Node current, Node next){
        int result = 0;
        if(current.val > next.val) {
            result = current.val - next.val;
            next.val = current.val;
        }
        return result;
    }
    
    public int trapRainWater(int[][] heightMap) {
        //First let's return the base cases.
        if(heightMap == null || heightMap.length <=1 || heightMap[0].length <= 1) return 0;
        
        //Initialize the heap
        PriorityQueue<Node> outerEdge = new PriorityQueue<Node>((heightMap.length + heightMap[0].length)*2, new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        
        int numRows = heightMap.length;
        int numCols = heightMap[0].length;
        
        //Put the first row and the last row into the heap.
        for(int i = 0; i < numCols; i++) {
            Node temp = new Node(0, i, heightMap[0][i]);
            Node temp2 = new Node(numRows - 1, i, heightMap[numRows-1][i]);
            outerEdge.add(temp);
            outerEdge.add(temp2);
            heightMap[0][i] = -1;
            heightMap[numRows-1][i] = -1;
        }
        
        //put the first column and last column into the queue and avoid the first and last items since they were added already last
        for(int i = 1 ; i < numRows - 1; i++) {
            Node temp = new Node(i, 0, heightMap[i][0]);
            Node temp2 = new Node(i, numCols - 1, heightMap[i][numCols-1]);
            outerEdge.add(temp);
            outerEdge.add(temp2);
            heightMap[i][0] = -1;
            heightMap[i][numCols-1] = -1;
        }
        
        int answer = 0;
        while(!outerEdge.isEmpty()){
            Node current = outerEdge.poll();
            //check up 
            if(current.x - 1 > 0 && heightMap[current.x-1][current.y] != -1) {
                Node next = new Node(current.x-1, current.y, heightMap[current.x - 1][current.y]);
                heightMap[current.x - 1][current.y] = -1;
                answer += calculateRainUnit(current,next);
                outerEdge.add(next);
            }
            //check down
            if(current.x + 1 < numRows - 1 && heightMap[current.x+1][current.y] != -1) {
                Node next = new Node(current.x+1, current.y, heightMap[current.x + 1][current.y]);
                heightMap[current.x + 1][current.y] = -1;
                answer += calculateRainUnit(current,next);
                outerEdge.add(next);
            }
            //check left
            if(current.y - 1 > 0 && heightMap[current.x][current.y-1] != -1) {
                Node next = new Node(current.x, current.y-1, heightMap[current.x][current.y-1]);
                heightMap[current.x][current.y-1] = -1;
                answer += calculateRainUnit(current,next);
                outerEdge.add(next);
            }
            //check right
            if(current.y + 1 < numCols - 1 && heightMap[current.x][current.y+1] != -1) {
                Node next = new Node(current.x, current.y+1, heightMap[current.x][current.y+1]);
                heightMap[current.x][current.y+1] = -1;
                answer += calculateRainUnit(current,next);
                outerEdge.add(next);
            }
            
            
        }
        
        
        return answer;
        
    }
}