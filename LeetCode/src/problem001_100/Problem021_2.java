package problem001_100;

import common.ListNode;

/**
 * Problem021_2
 *
 * @author: yry
 * @date: 2020/5/1
 */
public class Problem021_2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode ansNode = null;
        if (l1.val <= l2.val) {
            ansNode = new ListNode(l1.val);
            ansNode.next = mergeTwoLists(l1.next, l2);
        } else {
            ansNode = new ListNode(l2.val);
            ansNode.next = mergeTwoLists(l1, l2.next);
        }
        return ansNode;
    }

}
