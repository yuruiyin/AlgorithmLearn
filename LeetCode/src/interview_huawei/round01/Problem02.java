package interview_huawei.round01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Problem02 {

    class IntervalData {
        int left;
        int right;
        IntervalData(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    class CharData {
        char c;    // '(' or ')'
        int index; // 括号在字符串中的索引
        CharData(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    class CustomCmp implements Comparator<IntervalData> {

        @Override
        public int compare(IntervalData o1, IntervalData o2) {
            return o1.left - o2.left;
        }
    }

    public int longestValidParentheses(String s) {
        int size = s.length();
        Stack<CharData> stack = new Stack<>();
        IntervalData[] intervals = new IntervalData[size / 2];

        int intervalNum = 0;
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new CharData(c, i));
            } else {
                if (!stack.isEmpty() && stack.peek().c == '(') {
                    intervals[intervalNum++] = new IntervalData(stack.peek().index, i);
                    stack.pop();
                } else {
                    stack.push(new CharData(c, i));
                }
            }
        }

        if (intervalNum == 0) {
            return 0;
        }

        if (intervalNum == 1) {
            return intervals[0].right - intervals[0].left + 1;
        }

        // 合并区间
        Arrays.sort(intervals, 0, intervalNum, new CustomCmp());

        for (int i = 1; i < intervalNum; i++) {
            if (intervals[i].left - 1 == intervals[i - 1].right) {
                intervals[i].left = intervals[i - 1].left;
                intervals[i].right = intervals[i].right;
            } else if (intervals[i].left < intervals[i - 1].right) {
                intervals[i].left = intervals[i - 1].left;
                intervals[i].right = intervals[i - 1].right;
            }
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < intervalNum; i++) {
            int len = intervals[i].right - intervals[i].left + 1;
            if (len > maxLen) {
                maxLen = len;
            }
        }

        if (maxLen == Integer.MIN_VALUE) {
            return 0;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem02().longestValidParentheses("(()"));
        System.out.println(new Problem02().longestValidParentheses(")()())"));
        System.out.println(new Problem02().longestValidParentheses("(()())"));
        System.out.println(new Problem02().longestValidParentheses("()(()"));
        System.out.println(new Problem02().longestValidParentheses("())()"));
        System.out.println(new Problem02().longestValidParentheses("((()))())"));

    }
}
