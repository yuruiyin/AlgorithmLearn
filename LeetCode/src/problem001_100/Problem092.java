package problem001_100;

import common.ListNode;
import utils.PrintUtil;

public class Problem092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode mPrevNode = null;
        ListNode mNode = null;
        ListNode cur = head;
        ListNode prev = null;
        int index = 0;

        while (cur != null) {
            index++;
            if (index == m) {
                mNode = cur;
            }

            if (index + 1 == m) {
                mPrevNode = cur;
            }

            ListNode oldCurNext = cur.next;
            if (index > m && index < n) {
                cur.next = prev;
            }

            if (index == n) {
                mNode.next = cur.next;
                cur.next = prev;
                if (mPrevNode != null) {
                    mPrevNode.next = cur;
                    return head;
                }

                return cur;
            }

            prev = cur;
            cur = oldCurNext;
        }

        return null;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode resNode = new Problem092().reverseBetween(head, 2, 4);
        PrintUtil.printListNode(resNode);
    }
    
}
