package problem001_100;

import common.ListNode;
import utils.PrintUtil;

public class Problem061 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        // 计算节点个数
        int count = 0;
        ListNode tail = null;
        ListNode cursor = head;
        while (cursor != null) {
            count++;
            if (cursor.next == null) {
                tail = cursor;
            }
            cursor = cursor.next;
        }
        k %= count;

        if (k == 0) {
            return head;
        }

        tail.next = head;
        cursor = head;
        int moveCount = count - k - 1;
        while ((moveCount--) > 0) {
            cursor = cursor.next;
        }
        ListNode newHead = cursor.next;
        cursor.next = null;

        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new Problem061().rotateRight(head, 1);

        PrintUtil.printListNode(listNode);
    }
    
}
