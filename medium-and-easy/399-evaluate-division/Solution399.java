import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution399 {
    
    class Link {
        public String var;
        
        public Map<String, Double> paths;
        
        public Link(String var) {
            this.var = var;
            paths = new HashMap<String, Double>();
        }
        
        public String toString() {
            String result = this.var + " includes paths: ";
            for (String key : this.paths.keySet()) {
                result = result + " | " + key + " - " + this.paths.get(key) + " |";
            }
            
            return result;
        }
        
    }
    
    public double findLink(Map<String, Link> links, Set<String> visited, Link dividend, String divisor, double result) {
        
        //If the divisor is found in the paths for dividend, then I return the previous result multiple the value corresponding to the divisor
        if (dividend.paths.containsKey(divisor)) {
           return result * dividend.paths.get(divisor); 
        } else if (!visited.contains(dividend.var)) {
            visited.add(dividend.var);
            
            //For each of the possible paths in the current dividend, I need to check if there's a corresponding path down this pattern, if there is then I return the result
            for (String path : dividend.paths.keySet()) {
                
                double currentResult = findLink(links, visited, links.get(path), divisor, result * dividend.paths.get(path));
                
                if (currentResult != -1) return currentResult;
                
            }
            
        }
        
        return -1;
     
    }
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        double[] answer = new double[queries.size()];
        
        Map<String, Link> links = new HashMap<String, Link>();
    
        for (int i = 0; i < equations.size(); i++) {
            String firstCharacter = equations.get(i).get(0);
            String secondCharacter = equations.get(i).get(1);
            
            Map<String, Double> pathsA;
            Map<String, Double> pathsB;
            
            if (links.containsKey(firstCharacter)) {
                
                pathsA = links.get(firstCharacter).paths;
                
            } else {
                
                Link temp = new Link(firstCharacter);
                pathsA = temp.paths;
                links.put(firstCharacter, temp);
                
            }
            
            pathsA.put(secondCharacter, values[i]);
            
            if (links.containsKey(secondCharacter)) {
                pathsB = links.get(secondCharacter).paths;
            } else {
                Link temp = new Link(secondCharacter);
                pathsB = temp.paths;
                links.put(secondCharacter, temp);
            }
            
            pathsB.put(firstCharacter, 1/values[i]);
            
        }
        
        
        
//         for (String key : links.keySet()) {
//             System.out.println(key);
//             Link temp = links.get(key);
            
//             System.out.println(links.get(key));
//         }
        
        for (int i = 0; i < queries.size(); i++) {
            
            String firstCharacter = queries.get(i).get(0);
            String secondCharacter = queries.get(i).get(1);
            
            //This is the case when one of the character doesn't exist
            if (!links.containsKey(firstCharacter) || !links.containsKey(secondCharacter)) {
                answer[i] = -1.0;
                
                //This is the case when both character are the same
            } else if (firstCharacter.equals(secondCharacter)) {
                answer[i] = 1.0;
                
                //Use DFS to search through the charcters
            } else {
                
                //First I need to make sure I don't revisit the same character map, so create a set to store the visited characters
                Set<String> visited = new HashSet<String>();
                Link dividend = links.get(firstCharacter);
                
                answer[i] = findLink(links, visited, dividend, secondCharacter, 1);
                
            }
            
            
            
        }
        
        
        
        return answer;
        
        
    }
}