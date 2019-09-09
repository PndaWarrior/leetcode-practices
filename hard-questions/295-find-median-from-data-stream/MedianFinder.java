import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> right;
    PriorityQueue<Integer> left;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
        right = new PriorityQueue<Integer>();
        left = new PriorityQueue<Integer>((a,b) -> (b-a));
        
    }
    
    public void addNum(int num) {
        //If empty
        if ( left.isEmpty() && right.isEmpty() ) {
            left.offer(num);
        } else {
            
            int lSize = left.size();
            int rSize = right.size();
            
            // There are 3 cases to consider, if left has more item, if right has more item, if both has the same amount of items
            
            if( lSize > rSize) {
                if (num >= left.peek()) {
                    right.offer(num);
                } else {
                    right.offer(left.poll());
                    left.offer(num);
                }
            } else if (lSize == rSize ) {
                if ( num <= right.peek() ) {
                    left.offer(num);
                } else {
                    left.offer(right.poll());
                    right.offer(num);
                }
            }
        }
        
        // System.out.println("------ Completed operation for : " + num + " ------");
        // System.out.println(left.toString());
        // System.out.println(right.toString());
        
        
    }
    
    public double findMedian() {
        
        //Again there are only 3 cases, if lSize > rSize, rSize > lSize, and if they are equal
        
        if (left.size() == right.size()) {
            return ((double) left.peek() + (double) right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */