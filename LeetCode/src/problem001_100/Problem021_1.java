package problem001_100;

import common.ListNode;

/**
 * Problem021_1
 *
 * @author: yry
 * @date: 2020/5/1
 */
public class Problem021_1 {

    private void addNode(ListNode[] listNodes, int val) {
        if (listNodes[0] == null) {
            listNodes[0] = new ListNode(val);
            listNodes[1] = listNodes[0];
        } else {
            listNodes[1].next = new ListNode(val);
            listNodes[1] = listNodes[1].next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode[] listNodes = new ListNode[2]; // {head, cur}
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null && cur2 != null) {
            int minVal = Math.min(cur1.val, cur2.val);
            addNode(listNodes, minVal);
            if (cur1.val <= cur2.val) {
                cur1 = cur1.next;
            } else {
                cur2 = cur2.next;
            }
        }

        while (cur1 != null) {
            addNode(listNodes, cur1.val);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            addNode(listNodes, cur2.val);
            cur2 = cur2.next;
        }

        return listNodes[0];
    }

}
