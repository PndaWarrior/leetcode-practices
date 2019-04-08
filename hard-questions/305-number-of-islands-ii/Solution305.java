import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution305 {
            
    class UnionFind{
        
        int islandCount = 0;
        int cols = -1;
        
        HashMap<Integer, Integer> fathers = new HashMap<Integer, Integer>();
        
        int getId(int x, int y){
            return x*this.cols+y;
        }
        
        public UnionFind(int rows, int cols) {
        	
        	//when we initialize the union find data strcture, we first set all indexes as not an island, so each of the fathers key are pointed to -1
            this.cols = cols;
            for(int i = 0; i < rows; i++) {
               for(int j = 0; j < cols; j++) {
                   int current = getId(i, j);
                   fathers.put(current, -1);
               }
            } 
        }
        
        
        //Find will be used by union to see what's the furthest parent for a specific index.
        public int find(int id) {
            int parent = fathers.get(id);
            while(parent != fathers.get(parent)) {
                parent = fathers.get(parent);
            }
            
            int temp = -1;
            int current = id;
            
            while(current != fathers.get(current)) {
                temp = fathers.get(current);
                fathers.put(current, parent);
                current = temp;
            }
            
            return parent;
        }
        
        //union is needed later when we have multiple islands that needs to be unioned together as one big island
        public void union(int firstRow, int firstCol, int secondRow, int secondCol) {
            int firstId = getId(firstRow, firstCol);
            int secondId = getId(secondRow, secondCol);
            int firstParent = find(firstId);
            int secondParent = find(secondId);
            
            if(firstParent != secondParent) {
                if(firstParent > secondParent) {
                    fathers.put(secondParent, firstParent);
                } else {
                    fathers.put(firstParent, secondParent);
                }
                --islandCount;
            }
            
        }
        
        //utility method to check whether an index is land
        public boolean isLand(int row, int col) {
            int id = getId(row, col);
            return fathers.get(id) >= 0;
        }
        
        //when new land is added we need to set the father pointer to itself to indicate this is not a water anymopre
        public void setParent(int row, int col) {
            int id = getId(row, col);
            fathers.put(id, id);
            ++islandCount;
        }
        
        
        
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        List<Integer> numIslands = new ArrayList<Integer>();
        UnionFind uf = new UnionFind(m,n);
        
        for(int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            
            uf.setParent(row, col);
            
            if(col - 1 >= 0 && uf.isLand(row, col-1)) {
                uf.union(row, col, row, col-1);
            }
            if(col + 1 < n && uf.isLand(row, col+1)) {
                uf.union(row, col, row, col+1);
            }
            if(row - 1 >= 0 && uf.isLand(row-1, col)) {
                uf.union(row, col, row-1, col);
            }
            if(row + 1 < m && uf.isLand(row+1, col)) {
                uf.union(row, col, row+1, col);
            }
            
            numIslands.add(uf.islandCount);
        }
        
        
        return numIslands;
    }
}