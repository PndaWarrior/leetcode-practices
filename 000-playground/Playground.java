
public class Playground {
	


	public static void main(String[] args) {
		
		Playground current = new Playground();
		
		Playground.Node one = current.new Node(1);
		Playground.Node two = current.new Node(2);
		one.next = two;
		
		Playground.Node three = null;
		
		System.out.println(three == null);
	}
	

	private class Node{
		Node next;
		int value;
		public Node(int value) {
			this.value = value;
		}
	}

}