package contest.contest321;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class C {

    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int len = list.size();
        int[] sufMaxArr = new int[len];
        sufMaxArr[len - 1] = list.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            sufMaxArr[i] = Math.max(sufMaxArr[i + 1], list.get(i));
        }

        ListNode tmp = head;
        int i = 0;
        ListNode pre = null;
        ListNode resHead = null;
        while (tmp != null) {
            if (tmp.next == null) {
                if (pre == null) {
                    return tmp;
                }
                pre.next = tmp;
                break;
            }
            if (sufMaxArr[i + 1] > tmp.val) {
                // 移除
                if (pre != null) {
                    pre.next = tmp.next;
                }
            } else {
                if (pre == null) {
                    pre = tmp;
                    resHead = tmp;
                } else {
                    pre.next = tmp;
                    pre = pre.next;
                }
            }
            tmp = tmp.next;
            i++;
        }
        return resHead;
    }

}
