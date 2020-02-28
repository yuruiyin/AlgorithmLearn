package lcci;

import common.ListNode;

public class Lcci0203 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
