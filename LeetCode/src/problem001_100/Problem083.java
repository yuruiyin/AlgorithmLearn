package problem001_100;

import common.ListNode;

public class Problem083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cursor = head;

        while (cursor != null && cursor.next != null) {
            ListNode next = cursor.next;
            while (next != null && next.val == cursor.val) {
                cursor.next = next.next;
                next = cursor.next;
            }

            cursor = cursor.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode ans = new Problem083().deleteDuplicates(head);

        ListNode cursor = ans;
        while (cursor != null) {
            System.out.print(cursor.val + "->");
            cursor = cursor.next;
        }
        System.out.println();
    }


}
