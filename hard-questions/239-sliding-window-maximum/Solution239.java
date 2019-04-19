import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class Solution {    
    
    public void printDeque(Deque<int[]> deque) {
        System.out.println("Printing deque size of : " + deque.size());
        Iterator<int[]> list = deque.iterator();
        while(list.hasNext()) {
            int[] next = list.next();
            System.out.println("index : " + next[0] + " | value : " + next[1]);
        }
    }
        
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return new int[0];
        int[] answer = new int[nums.length-k+1];

        //Using Deque
        //When we encounter a number maximum, we can pop off anything that's to the left, since it's not going to be useful for us.  
        //let's simulate that first.
        //int[] will store two things,the value and the index where we saw the value
        Deque<int[]> deque = new ArrayDeque<int[]>();
        
        //Let's start by putting in the first number of k elements;
        
        for(int i = 0; i < k; i++) {
            int[] current = {i, nums[i]};
            
            while(!deque.isEmpty() && current[1] > deque.getLast()[1]) {
                deque.removeLast();
            }
            deque.addLast(current);
            
        }
        
        answer[0] = deque.getFirst()[1];
        
        int start = 1;
        int end = k;
        
        while(end < nums.length) {
            if(deque.getFirst()[0] < start) deque.removeFirst();
            int[] current = {end, nums[end]};
            while(!deque.isEmpty() && deque.getLast()[1] < current[1]) {
                deque.removeLast();
            }
            deque.addLast(current);
            answer[start] = deque.peekFirst()[1];
            ++start;
            ++end;
        }
        
        
        return answer;
    }
}