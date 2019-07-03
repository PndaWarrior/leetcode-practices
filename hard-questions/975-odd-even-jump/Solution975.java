import java.util.TreeMap;

class Solution975 {
    public int oddEvenJumps(int[] A) {
        
        if(A.length == 0 || A.length == 1) return A.length;
            
        
        boolean[] odd = new boolean[A.length];
        boolean[] even = new boolean[A.length];
        odd[A.length-1] = even[A.length-1] = true;
        
        TreeMap<Integer,  Integer> map = new TreeMap();
        map.put(A[A.length-1], A.length-1);
        
        int sum = 1;
        
        for(int i = A.length-2; i >= 0; i--) {
            
            //First check if the same number exist, because if the same number exist, it's definitely going to be the next jump point regardless
            
            int val = A[i];
            
            if(map.containsKey(val)) {
                int next = map.get(val);
                odd[i] = even[next];
                even[i] = odd[next];
            } else {
                
                //Check if performing an odd jump, is there a index to jump to
                Integer higherKey = map.higherKey(val);
                
                if(higherKey != null) {
                    odd[i] = even[map.get(higherKey)];
                }
                
                //check if performing an even jump, is there an index to jump to    
                Integer lowerKey = map.lowerKey(val);
                
                if(lowerKey != null) {
                    even[i] = odd[map.get(lowerKey)];
                }
                
                //since by default, the even and odd dp arrays are false, so if we can't find an index to jump to, leave it as false
                
            }
            
            //Check if starting point is good, we just need to check the odd array
            if(odd[i]) {
                sum++;
            }
            
            //After calculating out the dp function for current i, we insert it into our treemap
            map.put(val, i);
        }
        

        return sum;
        
    }
}