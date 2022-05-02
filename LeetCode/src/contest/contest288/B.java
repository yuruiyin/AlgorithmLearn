package contest.contest288;

import java.util.Map;

public class B {

    public String minimizeResult(String expression) {
        char[] arr = expression.toCharArray();
        int len = arr.length;
        int plusIdx = -1;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '+') {
                plusIdx = i;
            }
        }

        int ansMin = Integer.MAX_VALUE;
        String ansStr = null;
        for (int l = 0; l < plusIdx; l++) {
            int leftNum = l == 0 ? 1 : Integer.parseInt(expression.substring(0, l));
            int lNum = Integer.parseInt(expression.substring(l, plusIdx));
            String leftStr = l == 0 ? "" : String.valueOf(leftNum);
            String lStr = String.valueOf(lNum);
            for (int r = len - 1; r > plusIdx; r--) {
                int rNum = Integer.parseInt(expression.substring(plusIdx + 1, r + 1));
                int rightNum = r == len - 1 ? 1 : Integer.parseInt(expression.substring(r + 1, len));
                int value = leftNum * (lNum + rNum) * rightNum;
                if (value < ansMin) {
                    ansMin = value;
                    StringBuilder sb = new StringBuilder();
                    sb.append(leftStr + "(" + lStr);
                    String rightStr = r == len - 1 ? "" : String.valueOf(rightNum);
                    String rStr = String.valueOf(rNum);
                    sb.append("+");
                    sb.append(rStr + ")" + rightStr);
                    ansStr = sb.toString();
                }
            }
        }
        return ansStr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
