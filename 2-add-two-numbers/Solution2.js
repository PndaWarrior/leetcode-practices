/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {

    var result = new ListNode(0);
    var temp = result;
    var carry = 0;

    while(l1 !== null || l2 !== null) {
        var x = (l1 === null) ? 0 : l1.val;
        var y = (l2 === null) ? 0 : l2.val;

        var currentVal = x + y + temp.val;
        carry = (currentVal >= 10) ? 1 : 0;
        temp.val = currentVal % 10;
        if(l1 !== null) l1 = l1.next;
        if(l2 !== null) l2 = l2.next;

        if(l1 !== null || l2 != null || carry > 0) {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }
    }

    return result;


};
