package doubleContest.round40;

import common.ListNode;

import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/28
 */
public class B {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode pre = null;
        for (int i = 0; i < a ; i++, cur = cur.next) {
            pre = cur;
        }

        cur = list1;
        ListNode right = null;
        for (int i = 0; i <= b; i++, cur = cur.next);
        right = cur;
        pre.next = list2;
        ListNode end2 = null;

        cur = list2;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }

        end2 = cur;
        end2.next = right;
        return list1;
    }

}
