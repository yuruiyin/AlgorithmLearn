package contest.contest168;

public class Problem1295_1 {

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += (String.valueOf(num).length() % 2 == 0) ? 1 : 0;
        }

        return ans;
    }

}
