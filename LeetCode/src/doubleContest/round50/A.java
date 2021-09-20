package doubleContest.round50;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/17
 */
public class A {

    public int minOperations(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
