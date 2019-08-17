import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Playground {
	
	public static void main(String[] args) {
		   
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>(1, new Comparator<Double>(){
            public int compare(Double a, Double b) {
                int result = (a-b <= 0) ? -1 : 1;
                return result;
            }
        });
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(1, (a,b) -> (int)(a-b));

//        TreeMap<Integer, Integer> map = new TreeMap();
        
        
        
        List<Integer> temp = new ArrayList<Integer>();
        
        System.out.println(temp);
        
        int current = testReference(temp);
        
        System.out.println(temp);

        System.out.println(temp.size());
        
	}
	
	public static int testReference(List<Integer> list) {
		
		System.out.println(list.size());
		
		list.add(0);
		
		
		
		return 0;
	}

}
