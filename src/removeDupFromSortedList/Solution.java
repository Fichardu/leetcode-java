/**
 *Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 *For example,
 *Given 1->1->2, return 1->2.
 *Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next == null || (current.val != next.val)) {
                node.next = next;
                node = next;
            } 
            current = next;
        }
        
        return head;
    }
}