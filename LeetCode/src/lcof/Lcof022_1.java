package lcof;

import common.ListNode;

public class Lcof022_1 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while ((k--) > 0) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
