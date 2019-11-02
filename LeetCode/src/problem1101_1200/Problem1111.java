package problem1101_1200;

import java.util.Stack;

public class Problem1111 {

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                int stackSize = stack.size();
                int index = stack.pop();
                if ((stackSize & 1) == 0) {
                    ans[index] = 1;
                    ans[i] = 1;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
