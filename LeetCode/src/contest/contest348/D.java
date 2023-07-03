package contest.contest348;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    private Map<String, Long> memoMap;

    private long rec(int bitIdx, int bitSum, String maxNum) {
        if (bitSum < 0) {
            return 0;
        }

        if (bitIdx == 0) {
            if (maxNum.length() > 1) {
                return Math.min(9, bitSum) + 1;
            } else {
                int maxSum = Integer.parseInt(maxNum);
                return Math.min(9, Math.min(bitSum, maxSum)) + 1;
            }
        }

        if (bitSum == 0 || new BigInteger(maxNum).equals(BigInteger.ZERO)) {
            return 1;
        }


//        BigInteger curMaxNum = new BigInteger("1" + "0".repeat(bitIdx)).subtract(BigInteger.ONE);
//        if (curMaxNum.compareTo(bigMaxNum) <= 0) {
//            return Long.parseLong(curMaxNum.mod(new BigInteger(MOD + "")).toString());
//        }

        String key = bitIdx  + "," + bitSum + "," + maxNum;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        BigInteger bigMaxNum = new BigInteger(maxNum);

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            if (i > bitSum) {
                break;
            }
            BigInteger sum = new BigInteger(String.valueOf(i)).multiply(new BigInteger("1" + "0".repeat(bitIdx)));
            if (sum.compareTo(bigMaxNum) > 0) {
                break;
            }

            ans = (ans + rec(bitIdx - 1, bitSum - i, bigMaxNum.subtract(sum).toString())) % MOD;
        }

        memoMap.put(key, ans);
        return ans;
    }

    public int count(String num1, String num2, int minSum, int maxSum) {
        memoMap = new HashMap<>();
        long res2Max = rec(22, maxSum, num2);
        long res2Min = rec(22, minSum - 1, num2);
        long res2 = res2Max - res2Min;

        BigInteger bigNum1 = new BigInteger(num1);
        String num11 = bigNum1.subtract(new BigInteger("1")).toString();
        long res1Max = rec(22, maxSum, num11);
        long res1Min = rec(22, minSum - 1, num11);
        long res1 = res1Max - res1Min;

        return (int) ((res2 - res1) % MOD);
    }

}
