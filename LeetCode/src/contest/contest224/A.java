package contest.contest224;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class A {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        for (int[] re : rectangles) {
            maxLen = Math.max(maxLen, Math.min(re[0], re[1]));
        }

        int ans = 0;
        for (int[] re : rectangles) {
            if (Math.min(re[0], re[1]) == maxLen) {
                ans++;
            }
        }
        return ans;
    }

}
