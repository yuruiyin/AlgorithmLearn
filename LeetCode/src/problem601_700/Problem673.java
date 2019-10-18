package problem601_700;

public class Problem673 {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] max = new int[n];
        max[0] = 1;
        int maxLen = 1;

        // 标记以某个数为结尾的最长上升子序列的个数
        int[] count = new int[n];
        count[0] = 1;

        for (int i = 1; i < n; i++) {
            int prevMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && max[j] > prevMax) {
                    prevMax = max[j];
                }
            }

            if (prevMax == 0) {
                count[i] = 1;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j] && max[j] == prevMax) {
                        count[i] += count[j];
                    }
                }
            }

            max[i] = prevMax + 1;
            if (max[i] > maxLen) {
                maxLen = max[i];
            }
        }

        int maxLenCount = 0;
        for (int i = 0; i < n; i++) {
            if (max[i] != maxLen) {
                continue;
            }

            if (maxLen == 1) {
                maxLenCount++;
                continue;
            }

            //可能以一个节点为尾结点的最大上升子序列不止一个
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && max[j] == maxLen - 1) {
                    maxLenCount += count[j];
                }
            }
        }

        return maxLenCount;
    }

    public static void main(String[] args) {
        System.out.println(new Problem673().findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(new Problem673().findNumberOfLIS(new int[]{2,2,2,2,2}));
        System.out.println(new Problem673().findNumberOfLIS(new int[]{}));
        System.out.println(new Problem673().findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
        System.out.println(new Problem673().findNumberOfLIS(new int[]{1,2}));
        System.out.println(new Problem673().findNumberOfLIS(new int[]{3,1,2}));
        System.out.println(new Problem673().findNumberOfLIS(new int[]{-72,-93,-42,88,35,-86,-8,-10,98,-78}));
    }

}
