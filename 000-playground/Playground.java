import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Playground {
	
	public static void main(String[] args) {
		   
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>(1, new Comparator<Double>(){
            public int compare(Double a, Double b) {
                int result = (a-b <= 0) ? -1 : 1;
                return result;
            }
        });
        
        double temp = 5;
        
        minHeap.add(temp);
//        System.out.println(minHeap.toString());
        Random rand = new Random();
        int temp1 = rand.nextInt(1);
        
        System.out.println(temp1);
        

	}

}
