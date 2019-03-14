import java.util.HashMap;

class Solution904 {
    
    HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
    
    public int totalFruit(int[] tree) {
        int answer = 0, start = 0;
        for (int end = 0; end < tree.length; end++) {
            counter.put(tree[end], counter.getOrDefault(tree[end], 0) + 1);
            while(counter.size() >= 3) {
                counter.put(tree[start], counter.get(tree[start])-1);
                if(counter.get(tree[start]) == 0)
                    counter.remove(tree[start]);
                start++;
            }
            
            answer = Math.max(answer, end-start+1);
            
        }
        
        return answer;
        
    }
    
}