package contest.contest247;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/27
 */
public class A {

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
