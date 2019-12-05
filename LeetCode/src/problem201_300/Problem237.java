package problem201_300;

import common.ListNode;

public class Problem237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
