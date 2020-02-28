package lcci;

import common.ListNode;

public class Lcci0204 {

    public ListNode partition(ListNode head, int x) {
        ListNode minStart = null;  // 比x小的链表头
        ListNode minEnd = null;    // 比x小的链表尾
        ListNode maxStart = null;  // 比x大的链表头

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (cur.val < x) {
                if (minStart == null) {
                    minStart = cur;
                    minEnd = cur;
                } else {
                    minEnd.next = cur;
                    minEnd = minEnd.next;
                }

                if (prev != null && prev.val >= x) {
                    prev.next = minEnd.next;
                }

                if (maxStart != null) {
                    minEnd.next = maxStart;
                }
            } else {
                if (maxStart == null) {
                    maxStart = cur;
                }
            }

            prev = cur;
            cur = cur.next;
        }

        if (maxStart != null && minStart == null) {
            // 所有值都是大于等于x的
            return maxStart;
        }

        return minStart;
    }

}
