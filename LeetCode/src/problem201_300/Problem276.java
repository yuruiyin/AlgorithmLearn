package problem201_300;

public class Problem276 {

    // 第三种颜色选择依赖于前面两种相同和不相同
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        int diff = k * (k - 1);
        int same = k;
        for (int i = 2; i < n; i++) {
            int tmp = diff;
            // 前两者相同的情况下，当前颜色要与前者不一样，则有(k-1)种选择
            // 前两者不相同的情况下，当前颜色要与前者不一样，也是只有(k-1)种选择
            diff = same * (k - 1) + diff * (k - 1);
            same = tmp;
        }
        return same + diff;
    }

}
