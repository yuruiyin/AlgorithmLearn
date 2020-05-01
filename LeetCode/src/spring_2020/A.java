package spring_2020;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class A {

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
