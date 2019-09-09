import java.util.HashMap;
import java.util.Map;

class Solution833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    //Simple idea, we have to check each indexes to see if we a match between the sources and the string s, and for each found matched index we can simply store it in a map.  Later we need to loop through the original String S starting at index 0, to see if there's a found match between sources and target, if there is then we append on to the stringbuilder.  We will move our iterator by the number of characters we replaced by the source, so then we don't reuse a replaced character
        
        Map<Integer, Integer> matchedIndexes = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < indexes.length; i++) {
            int sourceIndex = indexes[i];
            int sourceLength = sources[i].length();
            if (S.substring(sourceIndex, sourceIndex + sourceLength).equals(sources[i])) {
                matchedIndexes.put(indexes[i], i);
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        int i = 0;
        
        while (i < S.length()) {
            //Check in the map, whether the index we're on is one of the found matched indexes
            if (matchedIndexes.containsKey(i)){
                //If we find a match, we need to build onto the stringbuilder 
                //in matchedIndexes, the key is the index where there's a match, the value is the index of sources and targets that we need to use on the newly built string.
                int replaceIndex = matchedIndexes.get(i);
                ans.append(targets[replaceIndex]);
                
                //We have to move the index i over the same amount as the number of characters we've replaced in the source string, or else we would be 
                i += sources[replaceIndex].length();
                
            } else {
                //for any index that's not a match in the map, then we just simply append the character from String S on the new strinbuilder
                ans.append(S.charAt(i));
                i++;
            }
            
            
        }
    
        return ans.toString();
    }
}