import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution142 {
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        Set<ListNode> visted = new HashSet<ListNode>();
        
        ListNode i = head;
        
        while(!visted.contains(i)) {
            visted.add(i);
            i = i.next;
            if(i == null) return null;
            
        }
        
        return i;
    }
}