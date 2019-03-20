import java.util.HashMap;

class Solution387 {
    public int firstUniqChar(String s) {
        int[] ans = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0 ; i < s.length(); i ++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                ans[i] = 1;
            } else {
                ans[i] = 2;
                ans[map.get(s.charAt(i))] = 2;
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (ans[i] == 1) return i;
        }
        return -1;
        
    }
}