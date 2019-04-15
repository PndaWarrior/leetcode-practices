import java.util.ArrayList;

public class JamesHeap {
	//Create a hash heap from scratch that allows the following operations
	// Add
	// Poll
	// remove
	// peek
	
	ArrayList<Integer> heap = new ArrayList<Integer>();
	String heapType;
	
	public JamesHeap(String type) {
		heapType = type;
	}

    
    public int leftChildOf(int index) {
    	return index*2+1;
    }
    
    public int rightChildOf(int index) {
    	return index*2+2;
    }
    
    public int parentOf(int index) {
    	if(index == 0) return 0;
    	else return (index-1)/2;
    }
    
	
    public void print() { 
    	System.out.println("Current heap size : " + heap.size());
        for (int i = 0; i <= (heap.size()-1)/3; i++) { 
        	StringBuilder result = new StringBuilder();
        	result.append(" PARENT : ");
        	result.append(heap.get(i));
        	 
        	
        	if(leftChildOf(i) < heap.size()) {
        		result.append(" LEFT Child : ");
        		result.append(heap.get(leftChildOf(i)));
        	}
        	
        	if(rightChildOf(i) < heap.size()) {
        		result.append(" RIGHT Child : ");
        		result.append(heap.get(rightChildOf(i)));
        	}

        	System.out.println(result);
            System.out.println(); 
        } 

    } 
    
    
    public void swap(int index_x, int index_y) {
    	int temp = heap.get(index_x);
    	heap.set(index_x, heap.get(index_y));
    	heap.set(index_y, temp);
    	
    }
    

    public void siftUp(int position) {
    	if(heapType == "min" && position > 0) {
    		
    		if( heap.get(parentOf(position)) > heap.get(position)) {
    			swap(parentOf(position), position);
        		siftUp(parentOf(position));
    		}
    	}else if(heapType == "max" && position > 0){
    		
    		if(position > 0 && heap.get(parentOf(position)) < heap.get(position)) {
    			swap(parentOf(position), position);
        		siftUp(parentOf(position));
    		}
    	}
    }
    
    public void siftDown(int position) {
    	if(heapType == "min") {
    		
    		//find smallest between left child, right child and current
    		int left = leftChildOf(position);
    		int right = rightChildOf(position);
    		
    		
    		int smallest = position;
    		
    		if(left < heap.size() && heap.get(position) > heap.get(left)) {
    			smallest = left;
    		}
    		
    		if(right < heap.size() && heap.get(right) < heap.get(smallest)) {
    			smallest = right;
    		}
    		
    		if(smallest != position) {
    			swap(position, smallest);
    			
    			siftDown(smallest);
    		}
    		
    		
    		
    	} else if (heapType == "max") {
    		
    		int left = leftChildOf(position);
    		int right = rightChildOf(position);
    		int largest = position;
    		
    		if(left < heap.size() && heap.get(position) < heap.get(left)) {
    			largest = left;
    		}
    		
    		if(right < heap.size() && heap.get(largest) < heap.get(right)) {
    			largest = right;
    		}
    		
    		if(largest != position) {
    			swap(position, largest);
    			
    			siftDown(largest);
    		}
    		
    	}
    	
    }
    
    public void add(int x) {
    	heap.add(x);
    	siftUp(heap.size()-1);
    }
    
    public int poll() {

    	if(heap.size() == 0) return -1;
    	
    	int result = heap.get(0);
    	
    	swap(0, heap.size()-1);
    	heap.remove(heap.size()-1);
    	
    	siftDown(0);
    	
    	print();
    	
    	return result;
    }
    
    public int peek() throws Exception {
    	if(heap.size() == 0) return -1;
    	return heap.get(0);
    }
    
    public int size() {
    	return heap.size();
    }
    
    public boolean isEmpty() {
    	return heap.isEmpty();
    }
    
    
    public static void main(String[] args) {
    	
    	JamesHeap min = new JamesHeap("min");
    	JamesHeap max = new JamesHeap("max");
    	
    	System.out.println("Print MIN HEAP");
    	min.add(2);
    	min.add(3);
    	min.add(7);
    	min.add(1);
    	min.add(8);
    	min.add(9);
    	min.add(4);
    	min.add(5);
    	min.add(6);
    	min.poll();
    	min.poll();
    	min.poll();
    	min.poll();
    	min.poll();
    	min.poll();

//    	System.out.println("Print MAX HEAP");
//    	max.add(2);
//    	max.add(3);
//    	max.add(7);
//    	max.add(1);
    	
    }
	
	

}
