package doubleContest.round52;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class D {

    private static final int N = 100002;
    private static final int MOD = (int) (1e9 + 7);

    public int sumOfFlooredPairs(int[] nums) {
        int[] countArr = new int[N];
        for (int num : nums) {
            countArr[num]++;
        }

        long[] preCountArr = new long[N];
        for (int i = 1; i < N; i++) {
            preCountArr[i] = preCountArr[i - 1] + countArr[i];
        }

        long ans = 0;
        for (int i = 1; i < N; i++) {
            if (countArr[i] == 0) {
                continue;
            }

            for (int j = i; j < N; j+=i) {
                if (j == i) {
                    ans = (ans + countArr[i] * countArr[i]) % MOD;
                    continue;
                }

                long x = preCountArr[j - 1] - preCountArr[j == i + i ? j - i : j - i - 1];
                ans = (ans + x * (j / i - 1) * countArr[i]) % MOD;
            }
        }

        return (int) ans % MOD;
    }
    
    public static void main(String[] args) {
        System.out.println(new D().sumOfFlooredPairs(new int[]{34912,57940,45747}));
        System.out.println(new D().sumOfFlooredPairs(new int[]{3,5,4}));
    }

}
