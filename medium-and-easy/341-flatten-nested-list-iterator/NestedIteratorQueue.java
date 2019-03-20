import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIteratorQueue implements Iterator<Integer> {
	

	  // This is the interface that allows for creating nested lists.
	  // You should not implement it, or speculate about its implementation
	  public class NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger() {
	    	  return true;
	      }
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger() {
	    	  return 0;
	      }
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList() {
	    	  return new LinkedList<NestedInteger>();
	      }
	  }
	
    Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
    
    public NestedIteratorQueue(List<NestedInteger> nestedList) {
        populateQueue(nestedList);
    }
    
    private void populateQueue(List<NestedInteger> list) {
        if(list == null);
        for(NestedInteger item : list) {
            if(!item.isInteger()) {
                populateQueue(item.getList());
            } else {
                queue.offer(item);
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty(); 
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */