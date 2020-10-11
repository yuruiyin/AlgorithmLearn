package contest.contest210;

import java.util.Stack;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/11
 */
public class A {

    public int maxDepth(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int leftCount = 0;
        int ansMax = 0;

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                ansMax = Math.max(ansMax, leftCount);
                leftCount--;
            }
        }

        return ansMax;
    }

}
