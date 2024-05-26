package contest.contest393;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    public long findKthSmallest(int[] coins, int k) {
        int len = coins.length;
        Arrays.sort(coins);
        if (coins[0] == 1) {
            return k;
        }

        int l = 1;
        int r = k;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int max = mid * coins[0];
            List<Integer> list = new ArrayList<>();
            list.add(coins[0]);
            int sum = mid;
            for (int i = 1; i < len; i++) {
                boolean isOk = true;
                for (int num: list) {
                    if (coins[i] % num == 0) {
                        isOk = false;
                        break;
                    }
                }
                if (!isOk) {
                    continue;
                }

                list.add(coins[i]);
                int totalCount = max / coins[i];
                // 需要减去与前面重叠的个数

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
