package contest.contest258;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/12
 */
public class B {

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public long interchangeableRectangles(int[][] rectangles) {
        long ans = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int[] rec : rectangles) {
            int gcd = gcd(rec[0], rec[1]);
            rec[0] /= gcd;
            rec[1] /= gcd;
            long key = rec[0] * 100001L + rec[1];
            long count = map.getOrDefault(key, 0L);
            ans += count;
            map.put(key, count + 1);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new B().interchangeableRectangles(new int[][]{
                {4,8},{3,6},{10,20},{15,30}
        }));
    }

}
