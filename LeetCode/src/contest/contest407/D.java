package contest.contest407;

public class D {

    public long minimumOperations(int[] nums, int[] target) {
        int len = nums.length;
        if (len == 1) {
            return Math.abs(nums[0] - target[0]);
        }
        long[] diff = new long[len];
        for (int i = 0; i < len; i++) {
            diff[i] = target[i] - nums[i];
        }

        // 正数：所有的升序段
        // 负数：所有的降序段
        long ans = 0;
        long preMin = 0;
        for (int i = 1; i < len; i++) {
            if (diff[i] * diff[i - 1] <= 0) {
                ans += Math.abs(diff[i - 1]) - Math.abs(preMin);
                preMin = 0;
            } else {
                if (diff[i] > 0) {
                    if (diff[i] < diff[i - 1]) {
                        ans += diff[i - 1] - preMin;
                        preMin = diff[i];
                    }
                } else {
                    if (diff[i] > diff[i - 1]) {
                        ans += -diff[i - 1] + preMin;
                        preMin = diff[i];
                    }
                }
            }
        }

        ans += Math.abs(diff[len - 1]) - Math.abs(preMin);
        return ans;
    }

    public static void main(String[] args) {
//        [1,1,5,9,9,6]
//        [1,9,7,5,8,3]
        System.out.println(new D().minimumOperations(new int[]{1,1,5,9,9,6}, new int[]{1,9,7,5,8,3}));
    }

}
