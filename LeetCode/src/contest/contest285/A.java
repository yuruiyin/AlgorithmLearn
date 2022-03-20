package contest.contest285;

public class A {

    public int countHillValley(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            int flag = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                if (nums[i] > nums[j]) {
                    flag = -1;
                } else {
                    flag = 1;
                }
                break;
            }

            if (flag == 0) {
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }

                if (flag == -1) {
                    if (nums[i] > nums[j]) {
                        ans++;
                    }
                } else {
                    if (nums[i] < nums[j]) {
                        ans++;
                    }
                }
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
