/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode returnAnswer = new ListNode(0);
        ListNode answer = returnAnswer;
        int carry = 0;

        while(l1 != null || l2 != null){
            if(l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val + carry;
            answer.val = sum % 10;
            carry = sum / 10;

            if(l1.next != null || l2.next != null || carry != 0) {

                answer.next = new ListNode(carry);
                answer = answer.next;
            }

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return returnAnswer;

    }
}
