package interview_bytedance.round12;

import common.ListNode;

public class Problem01 {

    private int getListNodeCount(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = getListNodeCount(headA);
        int countB = getListNodeCount(headB);

        int maxCount = Math.max(countA, countB);
        int minCount = Math.min(countA, countB);
        int diffCount = maxCount - minCount;
        ListNode headMax;
        ListNode headMin;
        if (countA == maxCount) {
            headMax = headA;
            headMin = headB;
        } else {
            headMax = headB;
            headMin = headA;
        }

        ListNode curMax = headMax;
        ListNode curMin = headMin;
        while ((diffCount--) > 0) {
            curMax = curMax.next;
        }

        while (curMax != null) {
            if (curMin == curMax) {
                return curMin;
            }
            curMax = curMax.next;
            curMin = curMin.next;
        }

        return null;
    }

}
