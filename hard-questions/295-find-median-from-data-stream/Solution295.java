import java.util.Comparator;
import java.util.PriorityQueue;

class Solution295 {
    PriorityQueue<Double> minHeap;
    PriorityQueue<Double> maxHeap;
    boolean rootIsNumber = false;
    double root = 0.0;
    
    /** initialize your data structure here. */
    public Solution295() {
            
        minHeap = new PriorityQueue<Double>(new Comparator<Double>(){
            public int compare(Double a, Double b) {
                int result = (a-b <= 0) ? -1 : 1;
                return result;
            }
        });

        maxHeap = new PriorityQueue<Double>(new Comparator<Double>() {
            public int compare(Double a, Double b) {
                int result = (b-a <= 0) ? -1 : 1;
                return result;
            }
        });
    }
    
    public void addNum(int num) {
        if(minHeap.size() == 0 && maxHeap.size() == 0 && !rootIsNumber) {
            root = (double)num;
        } else {
            if(rootIsNumber) {
                
                minHeap.add(Math.max((double)num, root));
                maxHeap.add(Math.min((double)num, root));
                
                root = (minHeap.peek() + maxHeap.peek())/2;
                
            } else {
                
                double middle = (double)num;
                double smaller = maxHeap.poll();
                double bigger = minHeap.poll();
                
                if(middle < smaller) {
                    double temp = middle;
                    middle = smaller;
                    smaller = temp;
                }else if (middle > bigger) {
                    double temp = middle;
                    middle = bigger;
                    bigger = temp;
                }
                
                root = middle;
                minHeap.add(bigger);
                maxHeap.add(smaller);
                
                
            }
        }
        
        rootIsNumber = !rootIsNumber;
        

        
    }
    
    public double findMedian() {
        return root;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */