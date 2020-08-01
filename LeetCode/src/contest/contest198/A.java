package contest.contest198;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/19
 */
public class A {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int count = numBottles;
        while (count >= numExchange) {
            int tmp = count / numExchange;
            ans += tmp;
            count = count % numExchange + tmp;
        }

        return ans;
    }

}
