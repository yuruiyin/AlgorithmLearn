package lcof;

import common.ListNode;
import utils.PrintUtil;

import java.util.List;

public class Lcof025 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode ans = null;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            ListNode newNode = null;
            if (l1.val <= l2.val) {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (ans == null) {
                ans = newNode;
                pre = ans;
            } else {
                pre.next = newNode;
                pre = newNode;
            }
        }

        while (l1 != null) {
            pre.next = new ListNode(l1.val);
            l1 = l1.next;
            pre = pre.next;
        }

        while (l2 != null) {
            pre.next = new ListNode(l2.val);
            l2 = l2.next;
            pre = pre.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        ListNode ans = new Lcof025().mergeTwoLists(l1, l2);

        PrintUtil.printListNode(ans);
    }

}
