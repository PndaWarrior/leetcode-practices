import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AutocompleteSystem {
    //I want to solve this problem using Tries
    
    // In my Trie Node, i need to keep track of the number of times this particular sentence has occured, the current sentence, the children that maps from this node ,and finally a list of top 3 hot items
    
    // The top 3 hot items need to be stored in an array list of trienodes, in order to allow me to compare them, I need to implement comparable class and have the compareTo function ready
    
    // I need to have a function to insert into my trie tree, I will keep this function out of the TrieNode class, since this will only ever be called on the root node ,it's not necessary to expose this function to ALL possible nodes
    
    // When I insert, I also need to remember the nodes I've visited, because once I've inserted a new sentence, I need to update all visited nodes with the frequency of this new node.
    
    //** Optimizations, we can simply use a character array instead of a map, since we are only dealing with characters, I'm just more used to using maps
    
    class TrieNode implements Comparable<TrieNode> {
        Map<Character, TrieNode> children;
        String s;
        int times;
        List<TrieNode> hotList;
        
        public TrieNode() {
            s = "";
            children = new HashMap<Character, TrieNode>();
            times = 0;
            hotList = new ArrayList<TrieNode>();
        }
        
        public int compareTo(TrieNode o) {
            
            //if both have the same times, then we compare by the sentence natural order
            if (this.times == o.times) {
                return this.s.compareTo(o.s);
            } else {
                //Remember that in comparisons, if we want smaller in the front then put this in the front
                //The reason is that, if this.times = 4, and o.times = 5, then 4 - 5 = -1, if it's -1 then it won't swap so it will put this in the front
                return o.times - this.times;
            }
            
        }
        
        public void update(TrieNode newNode) {
            if (!this.hotList.contains(newNode)) {
                this.hotList.add(newNode);
            }
            //We need to sort each time, becase we only update when a new node is inserted, so there could be a change in order of the frequency.
            Collections.sort(this.hotList);
            
            // Once we have top 3, simply remove the 4th items since that exceeds our need of the top 3 items
            if (this.hotList.size() > 3) {
                this.hotList.remove(this.hotList.size() - 1);
            }
            
        }
        
    }
    
    TrieNode root;
    TrieNode current;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuilder();
        root = new TrieNode();
        current = root;
        
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
        
    }
    
    public List<String> input(char c) {
        
        List<String> answer = new ArrayList<String>();
        
        if (c == '#') {
            
            //If at the end of an input, we need to insert the new sentence
            insert(sb.toString(), 1);
            
            current = root;
            sb = new StringBuilder();
            
            
        } else {
            
            sb.append(c);
            
            //Use the current node to find the next hot list, but if current is null, simply return the empty array
            if (current != null) {
                current = current.children.get(c);
            }
            
            if (current == null) {
                return answer;
            }
            
            for (TrieNode hotNodes : current.hotList) {
                answer.add(hotNodes.s);
            }
            
        }
        
        
        return answer;
    }
    
    public void insert(String s, int times) {
        //When I'm inserting, I need to first traverse through the trie tree to find the las tnode where the sentence is formed
        
        //I also need to keep track of all the items I've traversed through so I can update their hot list later.
        
        List<TrieNode> visitedNodes = new ArrayList<TrieNode>();
        
        TrieNode currentNode = this.root;
        StringBuilder tempSb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            tempSb.append(c);
            TrieNode next = currentNode.children.get(c);
            
            if (next == null) {
                next = new TrieNode();
                next.s = tempSb.toString();
                currentNode.children.put(c, next);
            }
            currentNode = next;
            visitedNodes.add(currentNode);
            
        }
        //At the end, I will find the last trie node that stores the full setence, so update the times for that node.
        currentNode.times += times;
        
        for (TrieNode visitedNode : visitedNodes) {
            visitedNode.update(currentNode);
        }
        
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */