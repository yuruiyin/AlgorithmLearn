package problem001_100;

import common.ListNode;

public class Problem024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode cursor = head;
        ListNode lastSecond = null;

        while (cursor != null && cursor.next != null) {
            ListNode first = cursor;
            ListNode second = cursor.next;
            if (lastSecond != null ) {
                lastSecond.next = second;
            }
            cursor = second.next;

            second.next = first;
            first.next = cursor;
            lastSecond = first;
        }

        return newHead;
    }

    public static void main(String[] args) {

    }
}
