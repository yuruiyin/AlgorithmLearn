package contest.contest283;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2022/3/6
 */
public class B {

    public long minimalKSum(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);

        Set<Integer> visited = new HashSet<>();
        long preSum = 0;
        long preDiffSum = 0;

        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            if (!visited.contains(nums[i])) {
                preDiffSum += nums[i];
                visited.add(nums[i]);
            }

            if (nums[i] - visited.size() == k) {
                return nums[i] * (nums[i] + 1L) / 2 - preDiffSum;
            } else if (nums[i] - visited.size() > k) {
                if (i > 0) {
                    int target = nums[i - 1] + (k - (nums[i - 1] - visited.size() + 1));
                    return target * (target + 1L) / 2 - (preDiffSum - nums[i]);
                } else  {
                    return k * (k + 1L) / 2;
                }
            }
        }

        long rightCount = k - (nums[len - 1] - visited.size());
        long target = nums[len - 1] + rightCount;
        return target * (target + 1L) / 2 - preDiffSum;
    }
    
    public static void main(String[] args) {
//        [96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84]
//        35
        System.out.println(new B().minimalKSum(new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84}, 35));
//        System.out.println("hello world");
    }
    
}
