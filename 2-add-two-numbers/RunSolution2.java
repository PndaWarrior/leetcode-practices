
public class RunSolution2 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(7);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;

		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		node4.next = node5;
		node5.next = node6;
		
		Solution2 solution = new Solution2();
		
		ListNode result = solution.addTwoNumbers(node1, node4);
		
		do {
			System.out.print(result.val);
			System.out.print(" -> ");
			result = result.next;
		} while  (result.next != null);
		
		System.out.println(result.val);
	}
}
