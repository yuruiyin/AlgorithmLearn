package doubleContest.round134;

public class D {

    public long countSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[len][32];
        int firstNum = nums[0];
        for (int i = 0; i < 32 && firstNum != 0; i++) {
            dp[0][i] = firstNum & 1;
            firstNum >>= 1;
        }

        long ans = nums[0] == k ? 1 : 0;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 0; j < 32 && num != 0; j++) {
                dp[i][j] = (num & 1) == 1 ? dp[i-1][j] + 1 : 0;
                num >>= 1;
            }
            int tmpK = k;
            int zeroCount = 1;
            int oneCount = i + 1;
            for (int j = 0; j < 32; j++) {
                int curBit = tmpK & 1;
                tmpK >>= 1;
                if (curBit == 0) {
                    if (dp[i][j] == 0) {

                    } else if (dp[i][j] == i + 1) {
                        // 没有
                        zeroCount = i + 2;
                        break;
                    } else {
                        zeroCount = Math.max(zeroCount, dp[i][j] + 1);
                    }
                } else {
                    oneCount = Math.min(oneCount, dp[i][j]);
                }
            }

            if (zeroCount != i + 2) {
                ans += Math.max(0, oneCount - zeroCount + 1);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new D().countSubarrays(new int[]{1, 1, 1}, 1));
        System.out.println(new D().countSubarrays(new int[]{1, 0, 10, 2, 5}, 1));
        System.out.println("hello");
    }

}
