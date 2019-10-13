package problem1_100;

public class Problem045 {

    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;

        if (n <= 1) {
            return 0;
        }

        for (int i = 0; i < n;) {
            if (nums[i] == 0) {
                ans = 0;
                break;
            }
            if (nums[i] >= n - i - 1) {
                ans++;
                break;
            }

            // 计算位置+元素的值的最大值
            int max = Integer.MIN_VALUE;
            int nextI = i + 1;
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (nums[j] != 0 && j + nums[j] > max) {
                    max = j + nums[j];
                    nextI = j;
                }
            }

            if (max == Integer.MIN_VALUE) {
                break;
            }

            i = nextI;
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem045().jump(new int[]{2,3,1,1,4}));
        System.out.println(new Problem045().jump(new int[]{0}));
        System.out.println(new Problem045().jump(new int[]{1}));
    }

}
