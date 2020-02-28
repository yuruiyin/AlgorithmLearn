package lcci;

import common.ListNode;

public class Lcci0202 {

    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        while ((k--) > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;
    }

}
