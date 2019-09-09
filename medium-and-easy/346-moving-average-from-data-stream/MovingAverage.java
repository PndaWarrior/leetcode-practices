import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    
    Queue<Integer> que;
    int size;
    double total = 0.0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        
        this.que = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        
        if (this.que.size() == this.size) {
            total -= this.que.poll();
        }
        
        que.offer(val);
        total += val;
        
        return total / this.que.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */