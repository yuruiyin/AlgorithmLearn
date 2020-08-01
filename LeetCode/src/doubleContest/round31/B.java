package doubleContest.round31;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/25
 */
public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int numOfSubarrays(int[] arr) {
        int len = arr.length;
        int oddSumCount = 0;
        int evenSumCount = 0;
        long ans = 0;
        if (arr[0] % 2 == 1) {
            ans++;
            oddSumCount++;
        } else {
            evenSumCount++;
        }

        int pre = arr[0];
        for (int i = 1; i < len; i++) {
            pre += arr[i];
            if (pre % 2 == 1) {
                ans++;
                ans = (ans + evenSumCount) % MOD;
                oddSumCount++;
            } else {
                ans = (ans + oddSumCount) % MOD;
                evenSumCount++;
            }
        }

        return (int) (ans % MOD);
    }
    
    public static void main(String[] args) {
        System.out.println(new B().numOfSubarrays(new int[]{1,2,3,4,5,6,7}));
    }

}
