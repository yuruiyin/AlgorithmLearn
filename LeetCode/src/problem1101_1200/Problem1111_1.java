package problem1101_1200;

import java.util.Stack;

public class Problem1111_1 {

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];

        boolean popToA = true; // 碰到第1，第3个)要pop，交替
        for (int i = 0; i < len; i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                stack.push(i);
                popToA = true;
            } else {
                if (!popToA) {
                    stack.pop();
                    popToA = true;
                } else {
                    ans[stack.pop()] = 1;
                    ans[i] = 1;
                    popToA = false;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
