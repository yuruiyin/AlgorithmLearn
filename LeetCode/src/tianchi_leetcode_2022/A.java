package tianchi_leetcode_2022;

import common.ListNode;

public class A {

    public int numberEvenListNode(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            if (cur.val % 2 == 1) {
                ans++;
            }
            cur = cur.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
