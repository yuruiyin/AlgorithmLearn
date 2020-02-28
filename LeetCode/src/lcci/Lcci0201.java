package lcci;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Lcci0201 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(head.val);
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            while (cur != null && visited.contains(cur.val)) {
                cur = cur.next;
            }

            pre.next = cur;
            pre = cur;
            if (cur != null) {
                visited.add(cur.val);
            }
        }

        return head;
    }

}
