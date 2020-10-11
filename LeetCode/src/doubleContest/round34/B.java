package doubleContest.round34;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/5
 */
public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int numWays(String s) {
        int oneCount = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] == '1') {
                oneCount++;
            }
        }

        if (oneCount % 3 != 0) {
            return 0;
        }

        int eachCount = oneCount / 3;

        if (eachCount == 0) {
            long ans = (long) (len - 1) * (len - 2) / 2;
            return (int) (ans % MOD);
        }

        int preCount = 0;
        int count1 = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '1') {
                preCount++;
            }

            if (preCount == eachCount) {
                int j;
                for (j = i + 1; j < len; j++) {
                    if (arr[j] == '1') {
                        break;
                    }
                }

                count1 = j - i;
                break;
            }
        }

        preCount = 0;
        int count2 = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                preCount++;
            }

            if (preCount == eachCount) {
                int to = i;
                int j;
                for (j = i - 1; j >= 0; j--) {
                    if (arr[j] == '1') {
                        break;
                    }
                }

                count2 = to - j;
                break;
            }
        }

        long ans = (long) count1 * count2;
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new B().numWays("10101"));
    }

}
