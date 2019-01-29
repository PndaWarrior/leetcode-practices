
public class Trie {
	
	TrieNode root;
	
	public Trie() {
        root = new TrieNode();
	}
	
	public void insert(int number) {
		
		TrieNode current = this.root;
		
		for(int i = 31; i >= 0; i--) {
			int curBit = (number >>> i) & 1;
			if(current.getChildren()[curBit] == null) {
				current.setChild(curBit, new TrieNode());
			}
			current = current.getChildren()[curBit];
		}
		current.setIsNumber(true);
		
	}
	
	public boolean containsNumber(int number) {

        TrieNode current = root;
		
        for(int i = 31; i >= 0 ; i--) {
        	int curBit = (number >>> i) & 1;
        	
        	TrieNode next = current.getChildren()[curBit];
        	
        	if(next == null) return false;
        	
        	current = next;
        }
        
        
		return current.isNumber();
	}
	
	
    boolean isEmpty() {
        return root == null;
    }

}
