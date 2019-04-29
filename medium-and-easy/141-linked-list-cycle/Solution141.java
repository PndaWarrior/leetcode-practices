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
public class Solution141 {
	
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode i = head;
        ListNode j = head.next;
        while(i != j) {
            if(j == null || j.next == null) return false;
            
            i = i.next;
            j = j.next;
            if(i == j) return true;
            j = j.next;
        }
        return true;
        
    }
}