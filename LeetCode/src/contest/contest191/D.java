package contest.contest191;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/31
 */
public class D {

    private int colorCount;
    private int[] balls;
    private BigInteger[] memo;
    private int ballCount;
    private BigInteger zeroBigInteger = new BigInteger("0");
    private int[] factorials;
    private BigInteger[] bigFactorials;

    private int arrToInt(int[] arr) {
        int ans = 0;
        for (int i = 0; i < colorCount; i++) {
            ans *= 8;
            ans += arr[i];
        }
        return ans;
    }

    private int getLeftColorCount(int[] chooseCntArr) {
        int leftColorCount = 0;
        for (int i = 0; i < colorCount; i++) {
            if (chooseCntArr[i] != 0) {
                leftColorCount++;
            }
        }
        return leftColorCount;
    }

    private int getRightColorCount(int[] chooseCntArr) {
        int rightColorCount = 0;
        for (int i = 0; i < colorCount; i++) {
            if (balls[i] - chooseCntArr[i] != 0) {
                rightColorCount++;
            }
        }
        return rightColorCount;
    }

    private BigInteger getTotal() {
        long ans1 = 1;
        for (int i = 0; i < colorCount; i++) {
            if (balls[i] != 0) {
                ans1 *= factorials[balls[i]];
            }
        }

        BigInteger bigInteger1 = new BigInteger(ans1 + "");
        BigInteger bigInteger = bigFactorials[ballCount];
        return bigInteger.divide(bigInteger1);
    }

    private BigInteger getAns(int[] chooseCntArr) {
        long ans1 = 1;
        for (int i = 0; i < colorCount; i++) {
            int rightCount = balls[i] - chooseCntArr[i];
            if (balls[i] != 0) {
                ans1 *= factorials[rightCount];
            }
        }

        BigInteger bigInteger1 = new BigInteger( ans1 + "");
        BigInteger bigInteger = bigFactorials[ballCount / 2];
        return bigInteger.divide(bigInteger1);
    }

    private BigInteger dp(int[] chooseCntArr, int count) {
        int key = arrToInt(chooseCntArr);
        if (memo[key] != null) {
            return memo[key];
        }

        int leftColorCount = getLeftColorCount(chooseCntArr);
        int rightColorCount = getRightColorCount(chooseCntArr);
        if (leftColorCount > rightColorCount) {
            memo[key] = zeroBigInteger;
            return zeroBigInteger;
        }

        if (count * 2 == ballCount) {
            BigInteger ans = zeroBigInteger;
            if (leftColorCount == rightColorCount) {
                ans = getAns(chooseCntArr);
            }

            memo[key] = ans;
            return ans;
        }

        BigInteger ans = zeroBigInteger;
        for (int i = 0; i < colorCount; i++) {
            if (balls[i] > chooseCntArr[i]) {
                chooseCntArr[i]++;
                ans = ans.add(dp(chooseCntArr, count + 1));
                chooseCntArr[i]--;
            }
        }

        memo[key] = ans;
        return ans;
    }

    private void calcFactorials() {
        factorials = new int[7];
        factorials[0] = 1;
        for (int i = 1; i <= 6; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
    }

    private void calcBigFactorials() {
        bigFactorials = new BigInteger[ballCount + 1];
        bigFactorials[0] = new BigInteger("1");
        for (int i = 1; i <= ballCount; i++) {
            bigFactorials[i] = bigFactorials[i-1].multiply(new BigInteger(i + ""));
        }
    }

    private void calcBallCount() {
        ballCount = 0;
        for (int num : balls) {
            ballCount += num;
        }
    }

    public double getProbability(int[] balls) {
        this.colorCount = balls.length;
        this.balls = balls;
        memo = new BigInteger[20000000];
        calcBallCount();
        calcFactorials();
        calcBigFactorials();
        BigDecimal bigCount = new BigDecimal(dp(new int[colorCount], 0));
        BigDecimal bigTotal = new BigDecimal(getTotal());
        BigDecimal ans = bigCount.divide(bigTotal, 10, RoundingMode.UP);
        return Double.parseDouble(ans.toString());
    }
    
    public static void main(String[] args) {
        System.out.println(new D().getProbability(new int[]{1, 1}));
        System.out.println(new D().getProbability(new int[]{2, 1, 1}));
        System.out.println(new D().getProbability(new int[]{3, 2, 1}));
        System.out.println(new D().getProbability(new int[]{6, 6, 6, 6, 6, 6}));
        System.out.println(new D().getProbability(new int[]{6, 6, 6, 6, 6, 6, 6, 6}));
    }

}
