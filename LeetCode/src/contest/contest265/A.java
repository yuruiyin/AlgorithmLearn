package contest.contest265;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/31
 */
public class A {

    public int smallestEqual(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
