package problem101_200;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Problem142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visitedSet = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (visitedSet.contains(cur)) {
                return cur;
            }

            visitedSet.add(cur);
            cur = cur.next;
        }

        return null;
    }

}
