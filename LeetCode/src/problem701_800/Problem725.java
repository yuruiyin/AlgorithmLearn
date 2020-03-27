package problem701_800;

import common.ListNode;

import java.util.List;

/**
 * Problem725
 *
 * @author: yry
 * @date: 2020/3/26
 */
public class Problem725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode cur = root;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int eachPartCount = count / k;
        int mod = count % k;
        ListNode[] ans = new ListNode[k];
        cur = root;
        int index = 0;
        while (cur != null) {
            ans[index++] = cur;
            ListNode pre = null;
            int offset = mod > 0 ? 1 : 0;
            for (int i = 0; i < eachPartCount + offset; i++) {
                pre = cur;
                cur = cur.next;
            }

            mod--;
            pre.next = null;
        }

        return ans;
    }

}
