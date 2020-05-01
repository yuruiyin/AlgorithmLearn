package lcp;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class Problem06 {

    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            while (coin > 0) {
                coin -= 2;
                ans++;
            }
        }
        return ans;
    }

}
