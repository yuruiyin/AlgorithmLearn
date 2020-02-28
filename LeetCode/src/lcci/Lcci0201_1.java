package lcci;

import common.ListNode;

public class Lcci0201_1 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        boolean[] visited = new boolean[20001];
        visited[head.val] = true;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            while (cur != null && visited[cur.val]) {
                cur = cur.next;
            }

            pre.next = cur;
            pre = cur;
            if (cur != null) {
                visited[cur.val] = true;
            }
        }

        return head;
    }

}
