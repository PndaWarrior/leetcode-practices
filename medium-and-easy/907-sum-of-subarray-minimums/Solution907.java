import java.util.Stack;

class Solution907 {
    public int sumSubarrayMins(int[] A) {
        
        Stack<Integer> previousLess = new Stack<Integer>();
        Stack<Integer> nextLess = new Stack<Integer>();
        
        //ple is the index to the previous less element
        //Right is the index to the next Less element
        int[] ple = new int[A.length];
        int[] nle = new int[A.length];
        
        for (int i = 0; i < A.length; i++) {
            
            //The monotonous  stack will be increasing in order out of all items I've visied, so top element will be the last element that's less than my current element
            while (!previousLess.isEmpty() && A[previousLess.peek()] > A[i]) previousLess.pop();
            
            ple[i] = (previousLess.isEmpty()) ? -1: previousLess.peek();
            previousLess.push(i);
        }
        
        for (int i = A.length-1; i >= 0; i--) {
            
            //Same idea as previousLess stack, except this time we go from the end, so this keep tracks of the next element that will be less than my current element
            while (!nextLess.isEmpty() && A[nextLess.peek()] >= A[i]) nextLess.pop();
            nle[i] = (nextLess.isEmpty()) ? A.length : nextLess.peek();
            nextLess.push(i);
        }
        
        //Once I calculated out the elements location where the last and next less element would be for each index, I calculate out the distance for them, and use that to calculate my result
        
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            int leftLength = i - ple[i];
            int rightLength = nle[i] - i;
            answer += A[i] * leftLength *rightLength;
            answer %= (1e9 + 7);
            
        }
        
        return answer;
    }
}