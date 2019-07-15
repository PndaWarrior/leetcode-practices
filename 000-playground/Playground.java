import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Playground {
	
	public static void main(String[] args) {
		   
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>(1, new Comparator<Double>(){
            public int compare(Double a, Double b) {
                int result = (a-b <= 0) ? -1 : 1;
                return result;
            }
        });

        TreeMap<Integer, Integer> map = new TreeMap();
        
        
        String helloWorld = "";
        
        helloWorld += "hello";
        
        helloWorld += "World";
        
        System.out.println(helloWorld);
        
        
	}

}
