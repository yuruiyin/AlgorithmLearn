package problem901_1000;

import java.util.*;

public class Problem903_1 {

    private static final int MOD = 1000000007;
    private char[] arr;
    private int len;
    private Map<String, Integer> memo;
    private int[] memoFrom;
    private int[] memoLastNum;

    private String arrToStr(boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sb.append(i).append("_");
            }
        }

        return sb.toString();
    }

    private int backTrack(int from, int lastNum, boolean[] visited) {
        if (from == len) {
            return 1;
        }

        String key = null;
        if (memoFrom[from] != -1 && memoLastNum[lastNum] != -1) {
            String visitedStr = arrToStr(visited);
            key = visitedStr + lastNum;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
        }

        char curChar = arr[from];
        int start;
        int end;
        if (curChar == 'D') {
            // 下降，要比前面一个数小
            start = 0;
            end = lastNum - 1;
        } else {
            // 上升
            start = lastNum + 1;
            end = len;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            int res = backTrack(from + 1, i, visited);
            visited[i] = false;
            sum += res;
        }

        if (key == null) {
            String visitedStr = arrToStr(visited);
            key = visitedStr + lastNum;
        }
        memo.put(key, sum);
        return sum;
    }

    public int numPermsDISequence(String str) {
        arr = str.toCharArray();
        len = arr.length;

        int ans = 0;
        memo = new HashMap<>();
        memoFrom = new int[len];
        memoLastNum = new int[len+1];
        Arrays.fill(memoFrom, -1);
        Arrays.fill(memoLastNum, -1);
        for (int i = 0; i <= len; i++) {
            boolean[] visited = new boolean[len+1];
            visited[i] = true;
            ans = (ans +  backTrack(0, i, visited)) % MOD;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem903_1().numPermsDISequence("IDDDIIDIIIII"));
    }
}
