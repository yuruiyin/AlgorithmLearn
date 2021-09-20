package doubleContest.round50;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/17
 */
public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int makeStringSorted(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        long[] preSumArr = new long[len];
        preSumArr[0] = 1;
        long[] f = new long[len];
        f[0] = 1;
        for (int i = 1; i < len; i++) {
            f[i] = ((preSumArr[i - 1] + 1) * (i + 1)) % MOD;
            preSumArr[i] = preSumArr[i - 1] + f[i];
        }

        int[][] countArr = new int[len][26];
        countArr[len - 1][arr[len - 1] - 'a']++;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (j == arr[i] - 'a') {
                    countArr[i][j] = countArr[i + 1][j] + 1;
                } else {
                    countArr[i][j] = countArr[i + 1][j];
                }
            }
        }

        int from = len - 1;
        long ans = 0;

        while (from > 0) {
            int next = -1;
            for (int i = from; i >= 1; i--) {
                if (arr[i] < arr[i - 1]) {
                    Set<Character> set = new HashSet<>();
                    for (int k = i; k < len; k++) {
                        if (arr[k] >= arr[i - 1]) {
                            break;
                        }
                        set.add(arr[k]);
                    }

                    int count = set.size(); // 比i-1小连续个数
                    int n = len - i;
                    long value = n == 1 ? 1 : ((preSumArr[n - 2] + 1) * count) % MOD;
                    ans = (ans + value) % MOD;

                    // 将后面弄成有序
                    int idx = i - 1;
                    int[] tmpCountArr = countArr[i - 1];
                    for (int k = 0; k < 26; k++) {
                        int tmpCount = tmpCountArr[k];
                        while ((tmpCount--) > 0) {
                            arr[idx++] = (char) (k + 'a');
                        }
                    }

                    next = i - 1;
                    break;
                }

            }

            if (next == -1) {
                break;
            }

            from = next;
        }

        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new D().makeStringSorted("aabaa"));
        System.out.println(new D().makeStringSorted("leetcodeleetcodeleetcode"));
    }

}
