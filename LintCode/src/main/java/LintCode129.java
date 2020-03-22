import utils.ListNode;

import java.util.List;

/**
 * LintCode129
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode129 {

    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int cap = hashTable.length;
        if (cap == 0) {
            return new ListNode[0];
        }

        int newCap = 2 * cap;
        ListNode[] ansArr = new ListNode[newCap];

        for (ListNode node : hashTable) {
            while (node != null) {
                int hash = (node.val % newCap + newCap) % newCap;
                ListNode cur = ansArr[hash];
                ListNode prev = null;
                while (cur != null) {
                    prev = cur;
                    cur = cur.next;
                }

                if (prev == null) {
                    ansArr[hash] = new ListNode(node.val);
                } else {
                    prev.next = new ListNode(node.val);
                }
                node = node.next;
            }

        }

        return ansArr;
    }

}
