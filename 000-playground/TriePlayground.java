
public class TriePlayground {
	


	public static void main(String[] args) {
		
//		Playground current = new Playground();
//		
//		Playground.Node one = current.new Node(1);
//		Playground.Node two = current.new Node(2);
//		one.next = two;
//		
//		Playground.Node three = null;
//		
//		System.out.println(three == null);
		
		
		Trie testTrie = new Trie();
		
		testTrie.insert(32);

		testTrie.insert(31);
		testTrie.insert(30);
		System.out.println(testTrie.containsNumber(32));
		System.out.println(testTrie.containsNumber(31));
		System.out.println(testTrie.containsNumber(36));
		System.out.println(testTrie.containsNumber(30));
		
		
		
	}
	

	private class Node{
		Node next;
		int value;
		public Node(int value) {
			this.value = value;
		}
	}

}