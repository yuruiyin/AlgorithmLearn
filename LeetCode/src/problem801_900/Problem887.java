package problem801_900;

public class Problem887 {

    private int[][] memo;

    private int recursive(int n, int k) {
        if (n <= 1 || k == 1) {
            return n;
        }

        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        int min = Integer.MAX_VALUE;
        int low = 1;
        int high = n;
        // 二分查找。找到碎和没碎需要的移动次数最接近的楼层。
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int brokenRes = recursive(mid - 1, k-1);
            int nonBrokenRes = recursive(n - mid, k);
            if (brokenRes > nonBrokenRes) { // brokenRes函数是对选择的楼层mid单调递增的。
                high = mid - 1;
                min = Math.min(min, brokenRes + 1);
            } else {
                low = mid + 1;
                min = Math.min(min, nonBrokenRes + 1);
            }
        }

        memo[n][k] = min;
        return min;
    }

    public int superEggDrop(int k, int n) {
        memo = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return recursive(n, k);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem04().superEggDrop(1, 2));  // 2
        System.out.println(new Problem887().superEggDrop(2, 6));  // 3
//        System.out.println(new Problem04().superEggDrop(3, 14)); // 4
//        System.out.println(new Problem04().superEggDrop(2, 2));  // 2
//        System.out.println(new Problem04().superEggDrop(2, 3));  // 2

    }

}
