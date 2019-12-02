package problem101_200;

import common.ListNode;
import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem143 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> nodeList = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }

        int size = nodeList.size();
        int mid = (size - 1) >>> 1;
        for (int i = 0; i <= mid; i++) {
            ListNode leftNode = nodeList.get(i);
            int right = size - i - 1;
            if (right != i) {
                ListNode rightNode = nodeList.get(right);
                leftNode.next = rightNode;
                if (i != mid) {
                    rightNode.next = nodeList.get(i+1);
                } else {
                    rightNode.next = null;
                }
            } else {
                leftNode.next = null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        new Problem143().reorderList(head);

        PrintUtil.printListNode(head);
    }

}
