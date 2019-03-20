class Solution421Enhanced {
    
    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        
        Trie root = new Trie();
        int result = Integer.MIN_VALUE;
        
        
        for (int num : nums) {
            Trie current = root,
                maxFinder =root;
            int curSum = 0;
            
            for(int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                
                if(current.children[curBit] == null) {
                    current.children[curBit] = new Trie();
                }
                current = current.children[curBit];
                                
                if(maxFinder.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    maxFinder = maxFinder.children[curBit ^ 1];
                } else {
                    maxFinder = maxFinder.children[curBit];
                }
            }
            result = Math.max(result, curSum);
            
        }
        return result;
        
    }
}