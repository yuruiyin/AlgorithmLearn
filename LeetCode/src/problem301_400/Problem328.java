package problem301_400;

import common.ListNode;

public class Problem328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next;
        ListNode evenHead = cur;
        ListNode oddTail = head;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode nextNext = next.next;
            oddTail.next = next;
            next.next = evenHead;
            cur.next = nextNext;
            oddTail = oddTail.next;
            cur = cur.next;
        }

        return head;
    }

}
