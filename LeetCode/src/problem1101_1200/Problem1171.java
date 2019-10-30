package problem1101_1200;

import common.ListNode;
import utils.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1171 {

    private ListNode dfs(ListNode head) {
        if (head == null) {
            return head;
        }
        List<Integer> sumList = new ArrayList<>();
        sumList.add(head.val);
        ListNode cursor = head.next;
        while (cursor != null) {
            sumList.add(sumList.get(sumList.size() - 1) + cursor.val);
            cursor = cursor.next;
        }

        // 判断前缀和是否有0
        int size = sumList.size();
        for (int i = 0; i < size; i++) {
            int sum = sumList.get(i);
            if (sum == 0) {
                int index = 0;
                ListNode cur = head;
                while (cur != null && index <= i) {
                    cur = cur.next;
                    index++;
                }
                return dfs(cur);
            }
        }

        // 判断有相等的前缀和
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int sum = sumList.get(i);
            if (indexMap.containsKey(sum)) {
                // 找到相等的sum
                int lastIndex = indexMap.get(sum);
                ListNode cur = head;
                int index = 0;
                while (cur != null && index < lastIndex) {
                    cur = cur.next;
                    index++;
                }

                ListNode last = cur;

                while (cur != null && index <= i) {
                    cur = cur.next;
                    index++;
                }

                last.next = cur;
                return dfs(head);
            } else {
                indexMap.put(sum, i);
            }
        }

        return head;
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode newHead = dfs(head);
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);


        PrintUtil.printListNode(new Problem1171().removeZeroSumSublists(head));
    }
    
}
