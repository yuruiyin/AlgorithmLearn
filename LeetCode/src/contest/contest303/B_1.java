package contest.contest303;

import java.util.TreeMap;

public class B_1 {

    static class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9+7);
        private long[] hash;
        private long[] power;
        private char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i-1] * P + arr[i]) % MOD;
                power[i] = (power[i-1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
        }

    }

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        // 字符串hash
        TreeMap<Long, Integer> rowCountMap = new TreeMap<>();
        TreeMap<Long, Integer> colCountMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(',');
            }
            StrHash strHash = new StrHash(sb.toString().toCharArray());
            long hash = strHash.getSubStrHash(0, sb.length() - 1);
            rowCountMap.put(hash, rowCountMap.getOrDefault(hash, 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append(',');
            }
            StrHash strHash = new StrHash(sb.toString().toCharArray());
            long hash = strHash.getSubStrHash(0, sb.length() - 1);
            colCountMap.put(hash, colCountMap.getOrDefault(hash, 0) + 1);
        }

        for (long rowHash : rowCountMap.keySet()) {
            int colCount = colCountMap.getOrDefault(rowHash, 0);
            if (colCount > 0) {
                ans += rowCountMap.get(rowHash) * colCount;
            }
        }

        return ans;
    }

}
