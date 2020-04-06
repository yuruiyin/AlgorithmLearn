package contest.contest183;

import java.math.BigInteger;

/**
 * B_1
 *
 * @author: yry
 * @date: 2020/4/5
 */
public class B_1 {

    public int numSteps(String s) {
        BigInteger bi = new BigInteger(s, 2);
        int ans = 0;
        while (!bi.equals(BigInteger.ONE)) {
            if (bi.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                // 偶数
                bi = bi.divide(BigInteger.TWO);
            } else {
                bi = bi.add(BigInteger.ONE);
            }
            ans++;
        }
        return ans;
    }

}
