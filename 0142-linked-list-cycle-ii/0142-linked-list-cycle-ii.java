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
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        int position = 0;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                tortoise = head;
                while (tortoise != hare) {
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
                return tortoise;
            }
        }
        return null;
    }
}
