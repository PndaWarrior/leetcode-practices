import java.util.HashSet;
import java.util.Set;

class Solution947 {
    
    public class UnionFind {
        
        int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i ++) {
                parent[i] = i;
            }
        }
        
        public int find(int i) {
            if(parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        
        public void union(int a, int b) {
            
            int parentA = find(a);
            int parentB = find(b);
            
            parent[parentB] = parentA; 
        }
        
    }
    
    public int removeStones(int[][] stones) {
        
        if (stones.length == 0 || stones.length == 1) return 0;
        
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        
        
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
                
            }
        }
        
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            seen.add(uf.find(i));
        }
        // System.out.println(seen.size());
        
        return n - seen.size();
        
    }
}