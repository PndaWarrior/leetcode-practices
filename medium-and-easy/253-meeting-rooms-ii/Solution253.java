import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution253 {

	 class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
	
    public int minMeetingRooms(Interval[] intervals) {
        
        if(intervals.length == 0) return 0;
        
        PriorityQueue<Integer> roomAllocator = new PriorityQueue<Integer>(
            intervals.length, 
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return a - b;
                }    
            });
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        roomAllocator.add(intervals[0].end);
        
        for(int i = 1; i < intervals.length; i++) {
            
            if(intervals[i].start >= roomAllocator.peek()) {
                roomAllocator.poll();
            }
            
            roomAllocator.add(intervals[i].end);
            
        }
        
        return roomAllocator.size();
        
        
    }
}