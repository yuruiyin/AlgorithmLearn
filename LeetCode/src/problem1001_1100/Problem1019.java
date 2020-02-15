package problem1001_1100;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem1019 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int size = list.size();

        Stack<Integer> stack = new Stack<>();
        int[] ansArr = new int[size];
        ansArr[size - 1] = 0;
        stack.push(list.get(size - 1));
        for (int i = size - 2; i >= 0; i--) {
            int curNum = list.get(i);
            while (!stack.isEmpty() && stack.peek() <= curNum) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ansArr[i] = 0;
            } else {
                ansArr[i] = stack.peek();
            }

            stack.push(curNum);
        }

        return ansArr;
    }

}
