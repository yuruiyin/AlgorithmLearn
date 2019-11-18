package contest.contest131;

import java.util.ArrayList;
import java.util.List;

public class Problem1021 {

    public String removeOuterParentheses(String str) {
        int leftCount = 0;
        int rightCount = 0;
        char[] arr = str.toCharArray();
        int len = arr.length;
        int leftIndex = 0;

        List<String> strList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == 1 && rightCount == 0) {
                leftIndex = i;
            }

            if (leftCount == rightCount) {
                strList.add(str.substring(leftIndex, i + 1));
                leftCount = 0;
                rightCount = 0;
            }
        }

        StringBuilder ansSb = new StringBuilder();
        for (String s : strList) {
            if (s.length() == 2) {
                continue;
            }
            ansSb.append(s.substring(1, s.length() - 1));
        }

        return ansSb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1021().removeOuterParentheses("()()"));
    }
    
}
