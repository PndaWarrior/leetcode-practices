import java.util.HashMap;
import java.util.Map;

class Solution359 {
    //I think we can use a que and a map
    
    //We can use the que to keep track of the orde of messages that came in
    
    //We can use a map to store all the messages that are currently existing in the que
    
    //When we receive a new message, we simply check the last item, to see if it is within 10 seconds, if it is within 10 seconds then we check against the map to see if the message exist
    
    //If the head item in que is NOT within 10 seconds, we can simply poll the item until it is within the 10 seconds range, nad for each polled item, we remove from the map.
    
    //We originally thought to use map because we want to take care of duplicate messages, but then again, we AREN"T allowing duplicate messages anyways, so we can just use a set
    
    //UPDATE, why use a queue and a set?  We don't need to kow what's currently in the last 10 seconds necessary.  We only need to know, if given a message, what was the last time this message has been printed, if we know the last time this message has been printed, then we can do a simple comparison to see if it's within the last 10 seconds, if so then dont' print, if not then update the time and print.
    
    Map<String, Integer> map = new HashMap<String, Integer>();
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(!map.containsKey(message) || timestamp >= map.get(message) + 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
        
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */