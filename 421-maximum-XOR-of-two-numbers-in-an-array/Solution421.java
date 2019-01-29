class Solution421 {
    
    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        
        Trie root = new Trie();
        
        for (int num : nums) {
            Trie current = root;
            
            for(int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if(current.children[curBit] == null) {
                    current.children[curBit] = new Trie();
                }
                current = current.children[curBit];
            }
            
        }
        
        int result = Integer.MIN_VALUE;
        
        for (int num : nums) {
            
            Trie current = root;
            int curSum = 0;
            
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if(current.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    current = current.children[curBit ^ 1];
                } else {
                    current = current.children[curBit];
                }
                
                
                
            }
            
            result = Math.max(result, curSum);
            
        }
        
        return result;
        
    }
}