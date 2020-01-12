package csp_s_level_test;

import java.util.*;

public class Problem02 {

    public static class Main {

        private int[] arr;
        private int len;
        private Map<String, Long> memoMap;

        private long backTrack(int from, int prevNum1, int prevNum2) {
            if (from == len) {
                return 0;
            }

            String key = from + "_" + prevNum1 + "_" + prevNum2;
            if (memoMap.containsKey(key)) {
                return memoMap.get(key);
            }

            if (from == 0) {
                long res =  backTrack(from + 1, arr[from], 0);
                memoMap.put(key, res);
                return res;
            }

            // 两种方案，跟第一个或第二个
            long res1 = backTrack(from + 1, arr[from], prevNum2) + Math.abs(arr[from] - prevNum1);
            long res2 = backTrack(from + 1, prevNum1, arr[from]) + (prevNum2 == 0 ? 0 : Math.abs(arr[from] - prevNum2));
            long res = Math.min(res1, res2);
            memoMap.put(key, res);
            return res;
        }

        private void solve() {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            arr = new int[n];
            this.len = n;
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            memoMap = new HashMap<>();
            System.out.println(backTrack(0, 0, 0));
        }

        public static void main(String[] args) {
            new Main().solve();
        }
    }



}
