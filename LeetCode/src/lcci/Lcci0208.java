package lcci;

import common.ListNode;
import utils.PrintUtil;

public class Lcci0208 {

    /**
     * 思路：
     * 1. 先让快慢指针相遇
     * 2. 快慢指针相遇之后，再定义一个指针从链表头开始，然后和相遇的点一起出发，再次相遇的点就是环的入口
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode circleStart = new ListNode(2);
        head.next = circleStart;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = circleStart;

        PrintUtil.printListNode(new Lcci0208().detectCycle(head));
    }

}
