package problem1101_1200;

import java.util.Map;

public class Problem1157_1 {

    /**
     * 暴力
     */
    class MajorityChecker {

        private int[] arr;

        private static final int MAX = 20001;

        public MajorityChecker(int[] arr) {
            this.arr = arr;
        }

        public int query(int left, int right, int threshold) {
            int[] countArr = new int[MAX];
            for (int i = left; i <= right; i++) {
                countArr[arr[i]]++;
            }
            for (int i = 1; i <= MAX; i++) {
                if (countArr[i] >= threshold) {
                    return i;
                }
            }
            return -1;
        }
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
