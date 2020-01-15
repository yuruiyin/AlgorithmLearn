package problem1301_1400;

public class Problem1312 {

    private char[] arr;
    private int[][] memo;  // 递归记忆化数组，避免重复计算

    private int backTrack(int from, int to) {
        if (from >= to) {
            return 0;
        }

        if (memo[from][to] != -1) {
            return memo[from][to];
        }

        // 头尾相等
        if (arr[from] == arr[to]) {
            return backTrack(from + 1, to - 1);
        }

        // 头尾不相等的最小次数是插入头字符或者插入尾字符的最小值 + 1
        memo[from][to] = Math.min(backTrack(from + 1, to) , backTrack(from, to - 1)) + 1;
        return memo[from][to];
    }

    public int minInsertions(String s) {
        arr = s.toCharArray();
        int len = arr.length;
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                memo[i][j] = -1;
            }
        }
        return backTrack(0, len - 1);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem04().minInsertions("leele"));
        System.out.println(new Problem1312().minInsertions("ccewnxhytsr"));
    }

}
