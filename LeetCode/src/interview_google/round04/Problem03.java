package interview_google.round04;

import java.util.ArrayList;
import java.util.List;

public class Problem03 {

    private List<String> ansList;

    private void backTrack(int n, int leftCount, int rightCount, StringBuilder sb) {
        if (leftCount > n) {
            return;
        }

        if (sb.length() == n * 2) {
            ansList.add(sb.toString());
            return;
        }

        if (leftCount == rightCount) {
            sb.append('(');
            backTrack(n, leftCount + 1, rightCount, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (leftCount > rightCount) {
            sb.append('(');
            backTrack(n, leftCount + 1, rightCount, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            backTrack(n, leftCount, rightCount + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            System.out.println("error");
        }
    }

    public List<String> generateParenthesis(int n) {
        ansList = new ArrayList<>();
        backTrack(n, 1, 0, new StringBuilder("("));
        return ansList;
    }
    
    public static void main(String[] args) {
        List<String> ansList = new Problem03().generateParenthesis(3);
        
        for (String str: ansList) {
            System.out.println(str);
        }
    }
    
}
