import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        //The idea to solve this problem is that, for any two words, word1 and word2, if word1 + word2 is a palindrome, then there must exist a substring palindrome in either word1 or word2, where the rest of the word is the reverse of the other word
        
        //Example: "llsd", "ds"  we know that word2 + word1 is a palindrome,  In word1, "ll" is also a palindrome, and for the rest of the word "sd", the reverse of that can be found in the map
        
        //Example: "abll", "ba", same case we know that word1 + word2 is a palindrome, in word1, "ll" is a substring palindrome,, and for the rest of the word "ab", the reverse of that can be found in the map.
        
        // The trick is that we will know where "the rest of the word" is when we determine a palindrome, if the rest of the word is on the right, then the reversed found item in the map must be on the left so we put that word in the front, vice versa for when the rest of the word is on the left.
        
        // This case is also valid for two words that are reverse to one another
        //Example: "abcd", "dcba"
        //we knonw that, word1+word2 is a palindrome, but so does word2 + word1
        //Using our previous condition, we see that in word1, "" is a palindrome, and the rest of the word to the right is "abcd", so the reverse of that can be found in the map, so we add word2 + word1 to the pair
        //when we chekc for word2, we see "" is a palindrome, and the rest of the word to the right is "dcba" and the reverse of that can be found in the map, so we add word1 + word2 to the list
        
        
        //To explain this concept in a simpler term, for any word, word1 = "abll", there are only two ways that's possible for it to be a palindrome pair, if the second word goes to the left or if the second word goes tot he right.  if it goes to the left, then it can only be "llb" or "llba", if it goes to the right, then it can ony be "llba", "lba", "ba"  T
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            
            for(int j = 0; j <= words[i].length(); j++) {
                
                String part1 = words[i].substring(0, j);
                String part2 = words[i].substring(j);
                
                if (isPalindrome(part1)) {
                    String reversePart2 = (new StringBuilder(part2)).reverse().toString();
                    if (map.containsKey(reversePart2) && map.get(reversePart2) != i) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(map.get(reversePart2));
                        temp.add(i);
                        answer.add(temp);
                    }
                    
                }
                
                if (isPalindrome(part2)) {
                    String reversePart1 = (new StringBuilder(part1)).reverse().toString();
                    if (map.containsKey(reversePart1) && map.get(reversePart1) != i && part2.length() != 0) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(i);
                        temp.add(map.get(reversePart1));
                        answer.add(temp);
                    }
                    
                }
                
                
            }
            
            
        }
        
        return answer;
        
        
        
        
    }
    
    public static boolean isPalindrome(String s) {
        
        int start = 0,
        end = s.length() - 1;
        
        while ( start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
    
    
}