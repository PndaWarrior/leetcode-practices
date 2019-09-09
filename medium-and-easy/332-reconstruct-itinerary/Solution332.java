import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        // To solve this problem, we need to be able to tell, if I'm starting at an airport A, and ends at Airport B, what's all the next possible flight that starts at Airpot B?
        
        // We can use a Map to store our itinerary where key is the starting airport, and value is the ending airport.
        // Problem is, it's possible to have more than one itinerary with the same starting airpot, so we can't just store String to String in our map, we need to keep some sort of order in our value
        // We have two options, we can either use a priority queue, which will help us keep the lexical order by putting the smaller lexical order at the top, or we can use a treemap which keeps the exact order of the array.
        // let's use PriorityQueue in this case
        
        LinkedList<String> answer = new LinkedList<String>();
        
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        
        //Insert all tickets into the map
        for (List<String> ticket : tickets) {
            
            PriorityQueue<String> airportCandidates;
            
            if (!map.containsKey(ticket.get(0))) {
                
                airportCandidates = new PriorityQueue<String>();
                airportCandidates.add(ticket.get(1));
                map.put(ticket.get(0), airportCandidates);
                
            } else {
                
                airportCandidates = map.get(ticket.get(0));
                airportCandidates.offer(ticket.get(1));
                
            }
        }
        
        dfs("JFK", map, answer);
        
        return answer;
        
    }
    

    public void dfs(String startingAirport, Map<String, PriorityQueue<String>> map, LinkedList<String> answer) {

        //Here's a problem, when we start with the airport JFK, it's possible that there are multiple entries that could've been the next airport.  Problem is that we don't know which next airport would be the second airport, 
        //For Example [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        // The expected answer is ["JFK","NRT","JFK","KUL"]
        // But because JFK has two inputs, one for KUL and one for NRT, when we pick up from the queue, the first one is KUL, so we will get JFK -> KUL, and then we need to start again with JFK because there are still items from JFK, so we will get JFK -> NRT.  This means that there's no way for me to know at which point of the final itinerary, it could be at the front or it could be in the middle.  So instead of building from the beginning, we can build from the end, so we keep recursively DFS till we get to the end, where there are no more airport Candidates, then we simply add the "startingAirport" in to the beginning of the list, then when the function stack pops, it will call the last function that we used to get the "startingAirport" that we just added.  When we get to the end of the function stack, it will be back at the starting location which is JFK, and then we build out the other half of the 
        
        // Since we can assume that all tickets form at least one valid itinerary, so we know for sure when we have to half of the 
        
        
        PriorityQueue<String> airportCandidates = map.get(startingAirport);
        
        while (airportCandidates != null && !airportCandidates.isEmpty()) {
            dfs(airportCandidates.poll(), map, answer);
        }
        
        answer.addFirst(startingAirport);
    }
}