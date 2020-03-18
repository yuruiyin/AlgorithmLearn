package lcci;

/**
 * Lcci1010_2
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class Lcci1010_2 {

    // 树状数组解法
    class StreamRank {

        private static final int MAX = 50010;
        private int[] arr;

        public StreamRank() {
            arr = new int[MAX];
        }

        public void track(int x) {
            x++;
            for (int i = x; i <= 50001; i += i & (-i)) {
                arr[i]++;
            }
        }

        public int getRankOfNumber(int x) {
            x++;
            int sum = 0;
            for (int i = x; i > 0; i -= i & (-i)) {
                sum += arr[i];
            }
            return sum;
        }
    }

}
