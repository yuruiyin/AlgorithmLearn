package problem101_200;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Problem160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null && !set.contains(cur)) {
            cur = cur.next;
        }

        return cur;
    }
    
    public static void main(String[] args) {

    }
    
}
