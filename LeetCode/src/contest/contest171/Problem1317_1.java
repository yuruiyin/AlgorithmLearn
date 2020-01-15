package contest.contest171;

import utils.PrintUtil;

public class Problem1317_1 {

    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        int t = 1;

        while (n > 0) {
            if (n == 1 || n % 10 >= 2) {
                int value = n % 10;
                int firstValue = 1;
                ans[0] += t * firstValue;
                ans[1] += (value - firstValue) * t;
                n /= 10;
            } else {
                int value = n % 10 + 10;
                int firstValue = 2;
                ans[0] += t * firstValue;
                ans[1] += (value - firstValue) * t;
                n = n / 10 - 1;
            }
            t *= 10;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] ans = new Problem1317_1().getNoZeroIntegers(2);
        PrintUtil.printIntArray(ans);
    }

}
