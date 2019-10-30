package problem001_100;

import common.ListNode;

public class Problem082 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cursor = head;
        ListNode prev = head;
        boolean isFirstDiff = true;
        ListNode newHead = null;
        while (cursor != null) { //每次从这里进去，cursor永远指向不重复元素和重复元素的第一个位置
            if (cursor.next == null || cursor.val != cursor.next.val) {
                if (isFirstDiff) {
                    newHead = cursor;
                    isFirstDiff = false;
                }

                if (prev != cursor) {
                    prev.next = cursor;
                }
                prev = cursor;
                cursor = cursor.next;
                continue;
            }

            // cursor.val == cursor.next.val ，说明这个值的节点可以跳过
            while (cursor.next != null && cursor.val == cursor.next.val) {
                cursor = cursor.next;
            }

            if (cursor.next == null) {
                // 到尾了
                prev.next = null;
                break;
            }
            cursor = cursor.next;

        }

        return newHead;
    }
    
    public static void main(String[] args) {

    }
    
}
