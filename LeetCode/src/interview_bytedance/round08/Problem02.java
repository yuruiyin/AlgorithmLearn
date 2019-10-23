package interview_bytedance.round08;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {

    private List<String> ansList;

    private void backTracking(int n, StringBuilder sb, int leftCount, int rightCount) {
        if (sb.length() == 2 * n) {
            ansList.add(sb.toString());
            return;
        }

        if (leftCount == rightCount) {
            sb.append('(');
            backTracking(n, sb, leftCount + 1, rightCount);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // leftCount > rightCount
            if (leftCount == n) {
                sb.append(')');
                backTracking(n, sb, leftCount, rightCount + 1);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append('(');
                backTracking(n, sb, leftCount + 1, rightCount);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(')');
                backTracking(n, sb, leftCount, rightCount + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public List<String> generateParenthesis(int n) {
        ansList = new ArrayList<>();
        backTracking(n, new StringBuilder("("), 1, 0);
        return ansList;
    }
    
    public static void main(String[] args) {
        List<String> ansList = new Problem02().generateParenthesis(3);
        
        for (String str: ansList) {
            System.out.println(str);
        }
    }
    
}
