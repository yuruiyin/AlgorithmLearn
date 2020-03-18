import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LintCode228
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode1661 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteNode(ListNode head, int n, int m) {
        if (m < n || head == null) {
            return head;
        }

        int i = 0;
        ListNode cur = head;
        ListNode pre = null;
        ListNode leftEnd = null;
        ListNode rightStart = null;
        while (cur != null) {
            if (i == n) {
                leftEnd = pre;
            }

            if (i == m) {
                rightStart = cur.next;
                break;
            }

            i++;
            pre = cur;
            cur = cur.next;
        }

        if (leftEnd == null && rightStart == null) {
            return head;
        } else if (leftEnd == null) {
            // 删除第0个元素
            return rightStart;
        } else {
            leftEnd.next = rightStart;
            return head;
        }
    }

}
