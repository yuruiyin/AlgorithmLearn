package contest.contest239;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/13
 */
public class A {

    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(i - start));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
