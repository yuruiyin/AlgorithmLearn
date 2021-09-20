package contest.contest250;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/18
 */
public class B {

    public int addRungs(int[] rungs, int dist) {
        int prev = 0;
        int ans = 0;
        for (int h : rungs) {
            if (h - prev > dist) {
                ans += ((h - prev) / dist - 1) + ((h - prev) % dist == 0 ? 0 : 1);
            }
            prev = h;
        }
        return ans;
    }

}
