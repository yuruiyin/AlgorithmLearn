package interview_baidu.round01;

import common.ListNode;

public class Problem03 {

    /**
     * 一次遍历
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode first = dumpy;
        ListNode second = dumpy;
        while (n-- >= 0) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dumpy.next;
    }

    /**
     * 两次遍历
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        int totalCount = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }

        if (fast == null) {
            totalCount = count * 2;
        } else {
            totalCount = count * 2 + 1;
        }

        int removedIndex = totalCount - n;

        if (removedIndex == 0) {
            head = head.next;
            return head;
        }

        ListNode curNode = head;
        while (--removedIndex > 0) {
            curNode = curNode.next;
        }

        if (curNode.next == null) {
            return null;
        }

        curNode.next = curNode.next.next;

        return head;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode ans = new Problem03().removeNthFromEnd1(head, 2);

        ListNode curNode = ans;

        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }

    }
}
