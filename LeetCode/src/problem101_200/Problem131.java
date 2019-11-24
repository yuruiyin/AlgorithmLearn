package problem101_200;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {

    private int sLen;
    private List<List<String>>[] memo;
    private boolean[][] isPaliArr;  //预处理各个区间是否为回文

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        int mid = (start + end) >>> 1;
        for (int i = start; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(end - i + start)) {
                return false;
            }
        }
        return true;
    }

    private List<List<String>> backTrack(String s, int start) {
        if (start == sLen) {
            return null;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        List<List<String>> ansList = new ArrayList<>();
        for (int end = start; end < sLen; end++) {
            if (isPaliArr[start][end]) {
                List<List<String>> subResList = backTrack(s, end + 1);
                if (subResList == null) {
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(start, end + 1));
                    ansList.add(list);
                    continue;
                }

                for (List<String> subList : subResList) {
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(start, end + 1));
                    list.addAll(subList);
                    ansList.add(list);
                }
            }
        }

        memo[start] = ansList;

        return ansList;
    }

    private void calcPali(String s) {
        isPaliArr = new boolean[sLen][sLen];
        for (int i = 0; i < sLen; i++) {
            for (int j = i; j < sLen; j++) {
                isPaliArr[i][j] = isPalindrome(s, i, j);
            }
        }
    }

    public List<List<String>> partition(String s) {
        sLen = s.length();
        memo = new ArrayList[sLen];
        calcPali(s);
        return backTrack(s, 0);
    }

}
