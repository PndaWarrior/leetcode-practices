import java.util.Stack;

class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[T.length];
        
        for(int i = T.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            int counter = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
            ans[i] = counter;
        }
        return ans;
    }
}