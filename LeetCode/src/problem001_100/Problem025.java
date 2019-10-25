package problem001_100;

import common.ListNode;

public class Problem025 {

    private int calcNodeCount(ListNode head) {
        int count = 0;
        ListNode cursor = head;
        while (cursor != null) {
            count++;
            cursor = cursor.next;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        if (head == null || head.next == null) {
            return head;
        }

        // 先计算节点个数
        int n = calcNodeCount(head);

        ListNode cursor = head;
        int leftNodeCount = n;
        ListNode newHead = head;
        ListNode lastKTail = null;
        boolean isFirstK = true;

        while (cursor != null) {
            if (leftNodeCount < k) {
                if (lastKTail != null) {
                    lastKTail.next = cursor;
                }
                break;
            }

            int tmpK = k;
            ListNode prev = null;
            ListNode oldLastKTail = lastKTail;
            lastKTail = cursor;
            while ((tmpK--) > 0) {
                ListNode next = cursor.next;
                cursor.next = prev;
                prev = cursor;
                cursor = next;
            }

            if (isFirstK) {
                newHead = prev;
            }

            if (oldLastKTail != null) {
                oldLastKTail.next = prev;
            }

            leftNodeCount -= k;
            isFirstK = false;
        }

        return newHead;

    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next  = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next  = new ListNode(4);
        head.next.next.next.next  = new ListNode(5);

        ListNode newHead = new Problem025().reverseKGroup(head, 6);

        while (newHead != null) {
            System.out.print(newHead.val + "->");
            newHead = newHead.next;
        }
    }
    
}
