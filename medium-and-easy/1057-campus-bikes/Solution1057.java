import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        
        //Previously we solve this problem using Priority Queue, however, the priority queue has 3 layers of sorting, so first it sorts by distance, then for all the same distance items it needs to sort by worker index, then within that it needs to sort by bike index.  The total sort is MN(Log(MN)) time.  To make it a bit faster, we know that we don't really need to sort the worker index and the bike index if we can make sure they retain the Original Order.  So in reality, we only need to make sure distance is sorted.  We can't keep using Priority Queue because if we do that we can't be sure we retain the original order.  Instead, we can use a TreeMap, and the key to the Map is the distance, and for all worker bike pair we found that has the same index, we simply keep the same order.  Later, when we process all the items, we start of with less distance items, and we update our answer array based on the order it's received previously, which would have worker index in the front, then bike index
        
        Map<Integer, List<int[]>> distMap = new TreeMap<Integer, List<int[]>>();
        
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                
                int currentDistance = distance(workers[i], bikes[j]);
                
                if (distMap.containsKey(currentDistance)) {
                    List<int[]> temp = distMap.get(currentDistance);
                    temp.add( new int[] {i, j});
                } else {
                    List<int[]> temp = new ArrayList<int[]>();
                    temp.add( new int[] {i, j});
                    distMap.put(currentDistance, temp);
                }
                
            }
        }
        
        int[] answers = new int[workers.length];
        boolean[] bikesTaken = new boolean[bikes.length];
        Arrays.fill(answers, -1);
        //If it's -1 then it's not taken, else it's taken
        
        //count will be used to count how many workers we have assigned a bike to
        int count = 0;
        
        for (int key : distMap.keySet()) {
            if (count == answers.length) break;
            List<int[]> pairs = distMap.get(key);
            
            for (int[] pair : pairs) {
                if(count == answers.length) break;
                
                int workerIndex = pair[0];
                int bikeIndex = pair[1];
                
                if (answers[workerIndex] == -1 && !bikesTaken[bikeIndex]) {
                    answers[workerIndex] = bikeIndex;
                    bikesTaken[bikeIndex] = true;
                    count++;
                }
                
            }
            
        }
        
        
        return answers;
        
    }
    
    
        public int[] assignBikesPriorityQueue(int[][] workers, int[][] bikes) {
        //The solution to this is a greedy solution, we need to calculate out all possible distances between all bikes
        
        //Example : Wroker
        // [[-1,-1],[0,0],[2,2]]
        //Example : Bikes
        // [[0,0],[3,3],[4,4]]
        
        // The expected output is [2, 0, 1] because the worker at 1 should take up bike at 0 since the distance is at 0.  So if we previously calculated out that work at 0 should take bike 0 because distance = 2, then we need to back that out.  This tells me that I need to basically calculate out all possible combinations of distances between bikes andn workers, then sort them by the distance,  if there are any with the same distance the assign the pair to the worker in smaller index, and if there are same distance for the same worker, i need to assign it to the smaller index bike
        
        // To calculate out all of the distances, we need to process n^2 times and store n^2 information
        // Then we need to sort this based on the distance first, then workeer index, then bike index.  
        //In Java I can achieve this by using a PriorityQueue with a custom comparator 
        
        //I need to store an object with 3 information, distance, then worker index, then bike index
        //So new int[3] will contain these 3 information.
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((obj1, obj2) -> {
            //If distance is not the same, the put the smaller distance in the front.
            if (obj1[0] != obj2[0]) {
                return obj1[0] - obj2[0];
            } else if (obj1[1] != obj2[1]) {
                //if ditance is the same, then put the one with smaller index worker in the front
                return obj1[1] - obj2[1];
            } else {
                return obj1[2] - obj2[2];
            }
        });
        
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = distance(workers[i], bikes[j]);
                heap.offer(new int[] {distance, i, j});
            }
        }
        
        int[] answers = new int[workers.length];
        boolean[] bikesTaken = new boolean[bikes.length];
        Arrays.fill(answers, -1);
        //If it's -1 then it's not taken, else it's taken
        
        //count will be used to count how many workers we have assigned a bike to
        int count = 0;
        
        while(count < answers.length) {
            int[] curr = heap.poll();
            int workerIndex = curr[1];
            int bikeIndex = curr[2];
            
            if (answers[workerIndex] == -1 && !bikesTaken[bikeIndex]) {
                answers[workerIndex] = bikeIndex;
                bikesTaken[bikeIndex] = true;
                count++;
            }
            
        }
        
        
        
        return answers;
        
    }
    
    
    public static int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}