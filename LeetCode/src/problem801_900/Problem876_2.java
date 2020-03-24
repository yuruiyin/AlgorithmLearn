package problem801_900;

import common.ListNode;

/**
 * Problem876_2
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class Problem876_2 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
