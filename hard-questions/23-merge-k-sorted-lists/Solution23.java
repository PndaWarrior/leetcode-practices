import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution23 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});

		for (ListNode ln : lists) {
			if (ln != null)
				heap.add(ln);
		}
		ListNode answer = (!heap.isEmpty()) ? heap.poll() : null;
		if (answer != null && answer.next != null)
			heap.add(answer.next);
		ListNode iterator = answer;

		while (!heap.isEmpty()) {
			ListNode current = heap.poll();
			if (current.next != null)
				heap.add(current.next);
			iterator.next = current;
			iterator = iterator.next;

		}

		return answer;

	}
}