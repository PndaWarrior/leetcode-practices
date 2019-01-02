import java.util.HashMap;

class Solution760 {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> mappings = new HashMap<Integer, Integer>();
        for(int i = 0; i < B.length; i++) {
            mappings.put(B[i], i);
        }
        
        int[] result = new int[B.length];
        
        for(int i = 0; i < result.length; i++) {
            result[i] = mappings.get(A[i]);
        }
        
        return result;
    }
}