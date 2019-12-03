package problem101_200;

import common.ListNode;

public class Problem160_1 {

    /**
     * 优化版本，O(1) 空间复杂度
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode cur = headA;
        while (cur != null) {
            countA++;
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            countB++;
            cur = cur.next;
        }

        ListNode maxCountHead = null;
        ListNode minCountHead = null;
        if (countA > countB) {
            maxCountHead = headA;
            minCountHead = headB;
        } else {
            maxCountHead = headB;
            minCountHead = headA;
        }

        int diff = Math.abs(countA - countB);

        ListNode maxCur = maxCountHead;
        while ((diff--) > 0) {
            maxCur = maxCur.next;
        }

        ListNode minCur = minCountHead;
        while (maxCur != null) {
            if (maxCur == minCur) {
                return maxCur;
            }
            maxCur = maxCur.next;
            minCur = minCur.next;
        }

        return null;
    }

}
