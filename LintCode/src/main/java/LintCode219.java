import java.util.List;

/**
 * LintCode228
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode219 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode insertNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val >= val) {
                if (pre == null) {
                    head = new ListNode(val);
                    head.next = cur;
                    return head;
                } else {
                    pre.next = new ListNode(val);
                    pre.next.next = cur;
                    return head;
                }
            }

            if (cur.next == null) {
                cur.next = new ListNode(val);
                return head;
            }

            pre = cur;
            cur = cur.next;
        }
        return new ListNode(val);
    }

}
