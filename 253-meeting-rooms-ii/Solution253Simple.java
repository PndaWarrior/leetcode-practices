import java.util.Arrays;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution253Simple {
	 class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
	
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int j = 0, rooms = 0;
        
        for(int i = 0; i < intervals.length; i++) {
            if(start[i] < end[j]){
                rooms++;
            } else {
                j++;
            }
        }
        return rooms;
        
        
    }
}