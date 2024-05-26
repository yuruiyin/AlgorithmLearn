package contest.contest358;

import common.ListNode;

import java.math.BigInteger;

public class B {

    public ListNode doubleIt(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        BigInteger bigInteger = new BigInteger(sb.toString());
        BigInteger res = bigInteger.multiply(BigInteger.TWO);
        char[] arr = res.toString().toCharArray();
        ListNode resNode = null;
        ListNode resHead = null;
        for (int i = 0; i < arr.length; i++) {
            if (resNode == null) {
                resNode = new ListNode(arr[i] - '0');
                resHead = resNode;
            } else {
                ListNode pre = resNode;
                resNode = new ListNode(arr[i] - '0');
                pre.next = resNode;
            }
        }
        return resHead;
    }

}
