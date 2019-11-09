package problem1001_1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem1087 {

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public String[] expand(String str) {
        char[] arr = str.toCharArray();
        Stack<String> stack = new Stack<>();

        boolean hasBrace = false;
        for (char c : arr) {
            if (c == '{') {
                hasBrace = true;
                break;
            }
        }

        if (!hasBrace) {
            return new String[]{str};
        }

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '}') {
                List<String> list1 = new ArrayList<>();
                while (!stack.isEmpty() && !stack.peek().equals("{")) {
                    String top = stack.pop();
                    if (!top.equals(",")) {
                        list1.add(top);
                    }
                }
                stack.pop();

                if (stack.isEmpty()) {
                    for (String letter: list1) {
                        stack.push(letter);
                    }
                } else {
                    List<String> list2 = new ArrayList<>();
                    while (!stack.isEmpty()) {
                        list2.add(stack.pop());
                    }

                    for (String str2: list2) {
                        for (String str1: list1) {
                            stack.push(str2 + str1);
                        }
                    }
                }
            } else if (i > 0 && isLetter(c) && arr[i-1] == '}') {
                List<String> list = new ArrayList<>();
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }

                for (String tmpStr: list) {
                    stack.push(tmpStr + c);
                }
            } else {
                stack.push(c + "");
            }
        }

        String[] ans = new String[stack.size()];
        int num = 0;

        while (!stack.isEmpty()) {
            ans[num++] = stack.pop();
        }

        Arrays.sort(ans);

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
