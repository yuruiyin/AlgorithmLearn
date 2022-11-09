package problem001_100;

public class Problem016_4 {

    private void sort(int[] nums) {
        // 因为数比较小，因此可以用O(N)算法进行排序
        int[] countArr = new int[2001];
        for (int num : nums) {
            countArr[num + 1000]++;
        }
        int idx = 0;
        for (int i = 0; i <= 2000; i++) {
            int count = countArr[i];
            while ((count--) > 0) {
                nums[idx++] = i - 1000;
            }
        }
    }

    // 3ms
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int ansSum = -1;
        int minDiff = Integer.MAX_VALUE;
//        Arrays.sort(nums);
        sort(nums);
        int end = len - 2;
        for (int i = 0; i < end; i++) {
            int gMinSum = nums[i] + nums[i + 1] + nums[i + 2];
            if (gMinSum >= target) {
                // 如果当前最小sum都大于等于target，那么继续遍历肯定diff必然会变大，因此直接break
                int diff = gMinSum - target;
                if (diff < minDiff) {
                    ansSum = gMinSum;
                }
                break;
            }

            int r = len - 1;
            int l = i + 1;
            while (l < r) {
                int minSum = nums[i] + nums[l] + nums[l + 1];
                if (minSum >= target) {
                    // 如果当前最小sum都大于等于target，那么继续遍历肯定diff必然会变大，因此直接break
                    int diff = minSum - target;
                    if (diff < minDiff) {
                        minDiff = diff;
                        ansSum = minSum;
                    }
                    break;
                }

                int maxSum = nums[i] + nums[r] + nums[r - 1];
                if (maxSum <= target) {
                    // 如果当前最大sum都小于等于target，那么继续遍历diff必然会变大，因此直接break
                    int diff = target - maxSum;
                    if (diff < minDiff) {
                        minDiff = diff;
                        ansSum = maxSum;
                    }
                    break;
                }

                int sum = nums[i] + nums[l] + nums[r];
                int diff;
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    diff = sum - target;
                    r--;
                } else {
                    diff = target - sum;
                    l++;
                }
                if (diff < minDiff) {
                    minDiff = diff;
                    ansSum = sum;
                }
            }
        }
        return ansSum;
    }



}
