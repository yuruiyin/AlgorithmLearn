package contest.contest281;

import common.ListNode;

public class B {

    public ListNode mergeNodes(ListNode head) {
        ListNode ans = head.next;
        ListNode cur = head.next.next;
        ListNode ansCur = ans;
        while (cur != null && cur.next != null) {
            if (cur.val == 0) {
                ansCur.next = cur.next;
                ansCur = ansCur.next;
                cur = cur.next.next;
                continue;
            }

            ansCur.val += cur.val;
            cur = cur.next;
        }
        ansCur.next = null;
        return ans;
    }

}
