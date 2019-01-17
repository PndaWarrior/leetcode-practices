import java.util.Arrays;
import java.util.Comparator;

class Solution406 {
    
 
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new SortByHeight());
        
         for(int[] person : people) {
             System.out.print(Arrays.toString(person) + " ,");
         }
         System.out.println();
        
        for( int i = people.length - 1; i >= 0; i--) {
            if(people[i][1] != 0 && i != people.length - 1) {
                moveBack(people, people[i][1], i);
            }
        }
        
        return people;
    }

    public void moveBack(int[][] people, int moves, int atIndex) {
        // System.out.println("current" + atIndex);
        // System.out.println("moves " + moves);
        for(int i = atIndex; i < atIndex + moves; i++) {
            int[] temp = people[i];
            people[i] = people[i+1];
            people[i+1] = temp;
        }
        
                
        // for(int[] person : people) {
        //     System.out.print(Arrays.toString(person) + " ,");
        // }
        // System.out.println();
    }
    
    
}

class SortByHeight implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        if(a[0] == b[0]) return b[1]-a[1];
        return a[0] - b[0];
    }
}
   