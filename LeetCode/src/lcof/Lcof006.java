package lcof;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Lcof006 {

    public int[] reversePrint(ListNode head) {
        List<Integer> ansList = new ArrayList<>();
        while (head != null) {
            ansList.add(head.val);
            head = head.next;
        }

        int len = ansList.size();
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            ansArr[i] = ansList.get(len - i - 1);
        }
        return ansArr;
    }

}
