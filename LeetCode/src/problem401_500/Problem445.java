package problem401_500;

import common.ListNode;

/**
 * Problem445
 *
 * @author: yry
 * @date: 2020/4/14
 */
public class Problem445 {

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode oldNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = oldNext;
        }
        return pre;
    }

    private ListNode add(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumListNode = null;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            if (sumListNode == null) {
                sumListNode = new ListNode(sum);
                pre = sumListNode;
            } else {
                ListNode cur = new ListNode(sum);
                pre.next = cur;
                pre = cur;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode cur = new ListNode(val);
            pre.next = cur;
            pre = cur;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode cur = new ListNode(val);
            pre.next = cur;
            pre = cur;
            l2 = l2.next;
        }

        if (carry != 0) {
            pre.next = new ListNode(carry);
        }

        return sumListNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);
        ListNode sumListNode = add(reverseL1, reverseL2);
        return reverse(sumListNode);
    }

}
