import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution56 {
	
	 public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	 }
        
    public void print(List<Interval> intervals) {
        for(int i = 0; i < intervals.size(); i++) {
            System.out.print("[" + intervals.get(i).start + ", " + intervals.get(i).end + "]");
            System.out.println();
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 1 || intervals.size() == 0 || intervals == null) return intervals;
        
        List<Interval> mergedIntervals = new ArrayList<Interval>();
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        mergedIntervals.add(intervals.get(0));
        
        for(int i = 1; i < intervals.size(); i++) {
            Interval lastInterval = mergedIntervals.get(mergedIntervals.size()-1);
            Interval currentInterval = intervals.get(i);
            
            if(lastInterval.end >= currentInterval.start) {
                Interval newInterval = new Interval(lastInterval.start, Math.max(currentInterval.end, lastInterval.end));
                mergedIntervals.set(mergedIntervals.size()-1, newInterval);
                   
            } else {
                mergedIntervals.add(intervals.get(i));
            }
        }
        
                         
        return mergedIntervals;
    }

}