import java.util.ArrayList;
import java.util.List;

class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        //Original problem [[0,2],[5,10],[13,23],[24,25]]
        //                 [[1,5],[8,12],[15,24],[25,26]]
        
        //We can solve this using two pointers, one going from Array A and one from Array B
        // If there is an interval between the current item for array A and B, then it will be from
        //Max( A.start, B.start) to Min( A.end, B.end).
        //Then we move the pointer over by 1 which ever one has the smaller end 
        
        // We have a couple of rules for moving over, if at the current index that A.start > B.End || B.start > A.end, then we simply ove over the other index because there can be no overlap
        
        // One thing I need to check is , could we have an input like so
        // [[ 0, 2], [2, 4]] and [[1,3]]
        
        //If this is possible then when we iterate through the intervals, we would first get that there's overlap from 1 to 2, and then when we move pointer A over, we will see there's an overlap from 2 to 3, I believe in this case we should merge the two results.
        
        // After checking with the interviewer, it seems that we can simply return [[1,2], [2,3]]
        
        //What if there are no intervals between the two array, what should the return be?
        //So given [[0,2], [2,4]] and [[5,6]] we should return an empty array.  This means that we need to somehow determine the result first, then create the int[][] array becasue we can't dynamically allocate value an int array
        
        
        List<int[]> answer = new ArrayList<int[]>();
        int aPointer = 0, bPointer = 0;
        
        while (aPointer < A.length && bPointer < B.length) {
            
            
            // we first check whether the two intervals intersect, if they don't then we continue
            // If current item on A has end smaller B's start, then move A over
            // if ( A[aPointer][1] < B[bPointer][0]) {
            //     aPointer++ ;
            //     continue;
            // } else if (A[aPointer][0] > B[bPointer][1]) {
            //     bPointer++;
            //     continue;
            // }
            
            //Note: The above commented code was the original thought.  There's an easier way to checkwhether the two interval intersect, we can simply check whether the interval values, low and high, whether low <= high.  The reason is let's say A start is biger than B end, then Math.max(A start, B start) would result in A start, and Math.min(A end, B end) would result in B end, so the result would be that low is > high. Below is the modified version of that code.
            
            // Then we can determine the overlapping intervals
            int low = Math.max(A[aPointer][0], B[bPointer][0]);
            int high = Math.min(A[aPointer][1], B[bPointer][1]);
            
            if (low <= high) {
                answer.add(new int[]{low, high});
            }
            
            
            //Now we're done with the current index we move over the pointer with smaller end
            if (A[aPointer][1] > B[bPointer][1]) {
                bPointer++;
            } else {
                aPointer++;
            }
            
        }
        
        int[][] result = new int[answer.size()][];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        
        
        return result;
    
        
    }
}