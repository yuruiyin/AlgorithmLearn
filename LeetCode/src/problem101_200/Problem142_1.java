package problem101_200;

import common.ListNode;

public class Problem142_1 {

    public ListNode detectCycle(ListNode head) {
        // 使用快慢指针
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // 快慢指针相遇之后，然后head和相遇点再往前走，第一个个相遇就是环的入口节点
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }

        return null;
    }

}
