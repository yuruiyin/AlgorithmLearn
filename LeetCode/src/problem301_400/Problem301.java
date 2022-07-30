package problem301_400;

import java.util.*;

public class Problem301 {

    private int minRemoveCount;
    private Set<String> ansSet;
    private String s;
    private int len;

    private Boolean[][][] memo;

    private int getMinRemoveCount(String s) {
        int leftCount = 0;
        int removeCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                if (leftCount == 0) {
                    removeCount++;
                } else {
                    leftCount--;
                }
            }
        }
        return removeCount + leftCount;
    }

    private boolean isOk(String s) {
        int leftCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                if (leftCount == 0) {
                    return false;
                }
                leftCount--;
            }
        }
        return leftCount == 0;
    }

    private boolean dfs(int curIdx, int leftCount, StringBuilder tmpSb) {
        if (leftCount < 0) {
            return false;
        }

        int removeCount = curIdx - tmpSb.length();
        if (removeCount > minRemoveCount) {
            return false;
        }

        Boolean memoRes = memo[curIdx][leftCount][removeCount];
        if (memoRes != null) {
            if (memoRes && removeCount == minRemoveCount) {
                String targetStr = tmpSb + (curIdx == len ? "" : s.substring(curIdx));
                ansSet.add(targetStr);
            }
            return memoRes;
        }

        if (removeCount == minRemoveCount) {
            // 达到最小的删除括号数
            String targetStr = tmpSb + (curIdx == len ? "" : s.substring(curIdx));
            if (isOk(targetStr)) {
                memo[curIdx][leftCount][removeCount] = true;
                ansSet.add(targetStr);
            } else {
                memo[curIdx][leftCount][removeCount] = false;
            }
            return memo[curIdx][leftCount][removeCount];
        }

        if (curIdx == len) {
            return false;
        }

        // 当前删或者不删
        char curChar = s.charAt(curIdx);
        if (Character.isLowerCase(curChar)) {
            //小写字母
            tmpSb.append(curChar);
            boolean isOk = dfs(curIdx + 1, leftCount, tmpSb);
            tmpSb.deleteCharAt(tmpSb.length() - 1);
            return isOk;
        }

        boolean removeRes = dfs(curIdx + 1, leftCount, tmpSb);
        tmpSb.append(curChar);
        boolean nonRemoveRes = dfs(curIdx + 1, curChar == '(' ? leftCount + 1 : leftCount - 1, tmpSb);
        tmpSb.deleteCharAt(tmpSb.length() - 1);
        return removeRes || nonRemoveRes;
    }

    public List<String> removeInvalidParentheses(String s) {
        this.minRemoveCount = getMinRemoveCount(s);
        this.len = s.length();
        this.s = s;
        ansSet = new HashSet<>();
        memo = new Boolean[26][26][26];
        dfs(0, 0, new StringBuilder());
        return new ArrayList<>(ansSet);
    }

}
