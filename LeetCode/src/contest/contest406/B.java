package contest.contest406;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B {

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode cur = head;
        ListNode newHead = null;
        ListNode pre = null;
//        Set<Integer> deleted = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur.val)) {
                if (pre == null) {
                    cur = cur.next;
                } else {
                    pre.next = cur.next;
                    cur.next = null;
                    cur = pre.next;
                }
            } else {
                if (newHead == null) {
                    newHead = cur;
                }
                pre = cur;
                cur = cur.next;
            }
        }

        return newHead;

    }

}
