package contest.contest270;

import common.ListNode;

/**
 * a
 *
 * @author: yry
 * @date: 2021/12/5
 */
public class B {

    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        cur = head;
        int i = 0;
        ListNode pre = null;
        while (cur != null) {
            if (i == size / 2) {
                if (pre == null) {
                    return null;
                }
                pre.next = cur.next;
            }
            i++;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

}
