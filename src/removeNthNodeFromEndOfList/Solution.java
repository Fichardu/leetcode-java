/**
 *Given a linked list, remove the nth node from the end of list and return its head.
 *
 *For example,
 *
 *  Given linked list: 1->2->3->4->5, and n = 2.
 *
 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
 *Note:
 *Given n will always be valid.
 *Try to do this in one pass.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            ++count;
        }
        if (n > count || n <= 0) {
            return head;
        } else if (n == count) {
            return head.next;
        }
        node = head;
        while (--count > n) {
            node = node.next;
        }
        if (node.next != null) {
            node.next = node.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; ++i)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}