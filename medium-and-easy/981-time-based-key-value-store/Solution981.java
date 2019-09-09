import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution981 {
    
    //NOTE we can easily lve thie problem using Tree Map, but tree map only exists in java so we approach this using binary search see below.
    
    class Pair{
        public String value;
        public int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
        
        public String toString() {
            return "[ value : " + this.value + ", timestamp" + this.timestamp + "]";
        }
    }
    
    Map<String, TreeMap<Integer, String>> map;
    
    /** Initialize your data structure here. */
    public Solution981() {
        
        map = new HashMap<String, TreeMap<Integer, String>>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        
        TreeMap<Integer, String> current;
        
        if (!map.containsKey(key)) {
            current = new TreeMap<Integer, String>();
            current.put(timestamp, value);
            map.put(key, current);
        } else {
            current = map.get(key);
            current.put(timestamp, value);
        }
        
    }
    
    public String get(String key, int timestamp) {
        
        if (!map.containsKey(key)) return "";
        
        TreeMap<Integer, String> candidates = map.get(key);
        
        //FloorKey returns the key, not the value
        Integer result = candidates.floorKey(timestamp);
        
        return (result == null) ? "" : candidates.get(result);
    }
    
        
    }
    
    
    // ------------------------------------------------------------------------------------------------
    
    //I'm going to still be using a hashmap to help me on the get operation.  However, when we perform a get on a key, we will basically get multiple possible values, and we need to get the value that's closest set to the timestamp.
    
    //what we can do is store a list of values given each key, and whenever we perform a get, we can use binary search to find the key in the list.  The reason we can use binary search is that we're storing things in order by timestamp
    
//     Map<String, List<Pair>> map;

//     public TimeMap() {
        
//         map = new HashMap<String, List<Pair>>();
        
//     }
    
//     public void set(String key, String value, int timestamp) {
        
//         Pair newValue = new Pair(value, timestamp);
//         List<Pair> list;
//         if (!map.containsKey(key)) {
//             list = new ArrayList<Pair>();
//             list.add(newValue);
//             map.put(key, list);
            
//         } else {
//             list = map.get(key);
//             list.add(newValue);
//         }
//     }
    
//     public String get(String key, int timestamp) {
//         //When we get, we will retrieve the list, and we will use binary search to search through the array becasue it's already sorted.  
        
//         if (!map.containsKey(key)) return "";
        
//         List<Pair> candidates = map.get(key);
        
//         return binarySearch(candidates, timestamp);
        
//     }
    
//     public String binarySearch(List<Pair> candidates, int timestamp) {
        
//         int start = 0;
//         int end = candidates.size() - 1;
        
//         //we use start + 1 < end because we are moving indexes, if we are at a state where start == end, we need to break even if the current item doesn't have the timestamp
//         while (start + 1 < end) {
            
//             int midIndex = (start + end) / 2;
//             Pair current = candidates.get(midIndex);
//             if (current.timestamp == timestamp) return current.value;
            
//             if (current.timestamp < timestamp) {
//                 start = midIndex + 1;
//             } else {
//                 end = midIndex - 1;
//             }
            
//         }
        
//         // start and end are both around the mid index, which should be where timestamp is correct, so we first check to see if end returns the timestamp correctly, if not then check if start returns with correct timestamp, else then there's no match, return empty string.
//         if (candidates.get(end).timestamp <= timestamp) return candidates.get(end).value;
//         if (candidates.get(start).timestamp <= timestamp) return candidates.get(start).value;

//         return "";
        
//     }
    
    
    

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */