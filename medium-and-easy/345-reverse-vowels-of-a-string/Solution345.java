import java.util.HashSet;

class Solution345 {
    HashSet<Character> vowels;
    public Solution345() {
        this.vowels = new HashSet<Character>();
        this.vowels.add('a');
        this.vowels.add('e');
        this.vowels.add('i');
        this.vowels.add('o');
        this.vowels.add('u');
        this.vowels.add('A');
        this.vowels.add('E');
        this.vowels.add('I');
        this.vowels.add('O');
        this.vowels.add('U');
    }
    public String reverseVowels(String s) {
        
        int length = s.length();
        int front = 0, back = length-1;
        StringBuilder result = new StringBuilder(s);
        
        while(front < back) {
            while(front < back && !this.vowels.contains(result.charAt(front))) front ++;
            while(front < back && !this.vowels.contains(result.charAt(back))) back--;
            
            char temp = result.charAt(front);
            result.setCharAt(front, result.charAt(back));
            result.setCharAt(back, temp);
            
            front ++;
            back --;
        }
        return result.toString();
    }
}