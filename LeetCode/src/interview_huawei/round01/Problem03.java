package interview_huawei.round01;

import common.ListNode;

public class Problem03 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ansListNode = null;
        int size = lists.length;

        ListNode curNode = ansListNode;
        while (true) {
            int minValue = Integer.MAX_VALUE;
            int minNodeIndex = -1;
            for (int i = 0; i < size; i++) {
                ListNode node = lists[i];
                if (node != null && node.val < minValue) {
                    minValue = node.val;
                    minNodeIndex = i;
                }
            }

            if (minNodeIndex == -1) {
                break;
            }

            if (ansListNode == null) {
                ansListNode = new ListNode(minValue);
                curNode = ansListNode;
            } else {
                curNode.next = new ListNode(minValue);
                curNode = curNode.next;
            }
            lists[minNodeIndex] = lists[minNodeIndex].next;
        }

        return ansListNode;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode ansListNode = new Problem03().mergeKLists(lists);

        ListNode curNode = ansListNode;
        while (curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
    }
}
