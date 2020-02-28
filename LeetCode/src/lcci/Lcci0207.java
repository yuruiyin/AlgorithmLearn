package lcci;

import common.ListNode;

public class Lcci0207 {

    private int getListNodeCount(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = getListNodeCount(headA);
        int countB = getListNodeCount(headB);
        int diff = Math.abs(countA - countB);
        ListNode minListNode;
        ListNode maxListNode;

        if (countA <= countB) {
            minListNode = headA;
            maxListNode = headB;
        } else {
            minListNode = headB;
            maxListNode = headA;
        }

        while ((diff--) > 0) {
            maxListNode = maxListNode.next;
        }

        while (minListNode != null) {
            if (minListNode == maxListNode) {
                return minListNode;
            }
            minListNode = minListNode.next;
            maxListNode = maxListNode.next;
        }

        return null;
    }

}
