
public class TrieNode {
	
	private TrieNode[] children;
	private boolean isNumber;
	
	public TrieNode() {
		this.children = new TrieNode[2];
	}
	
	public TrieNode[] getChildren() {
		return this.children;
	}
	
	public boolean isNumber() {
		return this.isNumber;
	}
	
	public void setIsNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}
	
	public void setChild(int index, TrieNode child) {
		this.children[index] = child;
	}

}
