package contest.contest248;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/4
 */
public class A {

    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println("hello");
    }

}
