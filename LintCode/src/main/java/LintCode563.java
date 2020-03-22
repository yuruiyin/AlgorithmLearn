import java.util.Arrays;

/**
 * LintCode563
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode563 {

    private int len;
    private int[] arr;
    private int[][] memo;

    private int dp(int idx, int target) {
        if (target == 0) {
            return 1;
        }

        if (idx == len || target < arr[idx] ) {
            return 0;
        }

        if (memo[idx][target] != -1) {
            return memo[idx][target];
        }

        int chooseRes = dp(idx + 1, target - arr[idx]);
        int nonChooseRes = dp(idx + 1, target);
        int ans = chooseRes + nonChooseRes;
        memo[idx][target] = ans;
        return ans;
    }

    public int backPackV(int[] nums, int target) {
        // write your code here
        arr = nums;
        len = arr.length;
        Arrays.sort(arr);
        memo = new int[len][target + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], - 1);
        }
        return dp(0, target);
    }

    public static void main(String[] args) {
        System.out.println(new LintCode563().backPackV(new int[]{
                81,112,609,341,164,601,97,709,944,828,627,730,460,523,643,901,602,508,401,442,738,443,555,471,97,644,184,964,418,492,920,897,99,711,916,178,189,202,72,692,86,716,588,297,512,605,209,100,107,938,246,251,921,767,825,133,465,224,807,455,179,436,201,842,325,694,132,891,973,107,284,203,272,538,137,248,329,234,175,108,745,708,453,101,823,937,639,485,524,660,873,367,153,191,756,162,50,267,166,996,552,675,383,615,985,339,868,393,178,932
        }, 80000));
    }

}
