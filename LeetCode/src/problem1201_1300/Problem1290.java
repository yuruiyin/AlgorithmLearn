package problem1201_1300;

import common.ListNode;

public class Problem1290 {

    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans <<= 1;
            ans += cur.val;
            cur = cur.next;
        }
        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
