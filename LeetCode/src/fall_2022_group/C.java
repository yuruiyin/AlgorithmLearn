package fall_2022_group;

import java.util.HashMap;
import java.util.Map;

public class C {

    private static final int MOD = 1000000007;

    public int beautifulBouquet(int[] flowers, int cnt) {
        int l = 0;
        int len = flowers.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        long ans = 1;
        countMap.put(flowers[0], 1);
        for (int r = 1; r < len; r++) {
            int oldCount = countMap.getOrDefault(flowers[r], 0);
            if (oldCount + 1 <= cnt) {
                countMap.put(flowers[r], oldCount + 1);
            } else {
                while (l < r) {
                    countMap.put(flowers[l], countMap.getOrDefault(flowers[l], 0) - 1);
                    if (flowers[l] == flowers[r]) {
                        l++;
                        break;
                    }
                    l++;
                }
                countMap.put(flowers[r], cnt);
            }
            ans = (ans + (r - l + 1)) % MOD;
        }
        return (int) (ans % MOD);
    }

}
