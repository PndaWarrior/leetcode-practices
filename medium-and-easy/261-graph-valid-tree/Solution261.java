import java.util.Arrays;

class Solution261 {
    
    int numUnions = 0;
    int[] unions;
    
    int find(int x) {
        int i = x;
        int parent = unions[i];
        while(parent != -1){
            i = parent;
            parent = unions[i];
        }
        return i;
    }
    
    public boolean validTree(int n, int[][] edges) {
        this.unions = new int[n];
        Arrays.fill(unions, -1);

        numUnions = n;
        
        for(int i = 0; i < edges.length; i++) {
            int firstParent = find(edges[i][0]);
            int secondParent = find(edges[i][1]);
            
            //two items in an union have another edge, must be a loop
            if(firstParent == secondParent) return false;
            
            //Union the two now that there's an edge connected
            unions[firstParent] = secondParent;
            --numUnions;
        }
        
        return numUnions == 1;
        
    }
}