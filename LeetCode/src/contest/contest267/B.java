package contest.contest267;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/14
 */
public class B {

    private void reverse(List<ListNode> list, int s, int e) {
        while (s < e) {
            ListNode tmp = list.get(s);
            list.set(s, list.get(e));
            list.set(e, tmp);
            s++;
            e--;
        }
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int sum = 1;
        for (int i = 2; sum < list.size() ;i++) {
            int preSum = sum;
            sum += i;
            if (sum >= list.size()) {
                if ((list.size() - preSum) % 2 == 0) {
                    reverse(list, preSum, list.size() - 1);
                }
                break;
            }

            if (i % 2 == 0) {
                reverse(list, preSum, sum - 1);
            }
        }

        ListNode resHead = list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return resHead;
    }

}
