package lcof;

import common.ListNode;

public class Lcof022 {

    private int getListNodeCount(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = getListNodeCount(head);
        k = count - k;

        int index = 0;
        ListNode cur = head;
        while (cur != null) {
            if ((index++) == k) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

}
