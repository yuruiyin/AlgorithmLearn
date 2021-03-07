package contest.contest223;

import common.ListNode;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/10
 */
public class B {

    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode curNode = head;
        while (curNode != null) {
            n++;
            curNode = curNode.next;
        }

        if (n == 1) {
            return head;
        }

        k = Math.min(n + 1 - k, k);

        int cur = k;
        ListNode left = null;
        ListNode leftLeft = null;
        ListNode leftRight = null;

        curNode = head;
        while ((cur--) > 0) {
            leftLeft = left;
            left = curNode;
            leftRight = left.next;
            curNode = curNode.next;
        }

        ListNode right = null;
        ListNode rightLeft = null;
        ListNode rightRight = null;
        curNode = head;
        cur = n + 1 - k;
        while ((cur--) > 0) {
            rightLeft = right;
            right = curNode;
            rightRight = right.next;
            curNode = curNode.next;
        }

        if (left == right) {
            return head;
        }

        if (leftLeft == null) {
            if (leftRight == right) {
                right.next = left;
                left.next = null;
                return right;
            }
            right.next = leftRight;
            rightLeft.next = left;
            left.next = null;
            return right;
        }

        if (leftRight == right) {
            leftLeft.next = right;
            right.next = left;
            left.next = rightRight;
            return head;
        }

        leftLeft.next = right;
        right.next = leftRight;
        rightLeft.next = left;
        left.next = rightRight;

        return head;
    }

}
