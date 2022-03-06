package contest.contest265;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/31
 */
public class B {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int pre = 0;
        ListNode cur = head;
        List<Integer> indexList = new ArrayList<>();
        int i = 0;
        while (cur != null && cur.next != null) {
            if (pre == 0) {
                pre = cur.val;
                cur = cur.next;
                i++;
                continue;
            }

            if (cur.val > pre && cur.val > cur.next.val || (cur.val < pre && cur.val < cur.next.val)) {
                indexList.add(i);
            }

            pre = cur.val;
            cur = cur.next;
            i++;
        }

        int size = indexList.size();

        if (size <= 1) {
            return new int[]{-1, -1};
        }

        int maxDis = indexList.get(size - 1) - indexList.get(0);
        int minDis = 100001;

        for (int j = 1; j < indexList.size(); j++) {
            minDis = Math.min(minDis, indexList.get(j) - indexList.get(j -1));
        }

        return new int[] {minDis, maxDis};
    }

}
