package lcof;

import common.ListNode;

public class Lcof018 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }

            pre = cur;
            cur = cur.next;
        }

        return head;
    }

}
