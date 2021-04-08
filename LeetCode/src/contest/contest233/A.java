package contest.contest233;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/21
 */
public class A {

    public int maxAscendingSum(int[] nums) {
        int len = nums.length;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] <= nums[j - 1]) {
                    break;
                }
                sum += nums[j];
            }
            ansMax = Math.max(ansMax, sum);
        }
        return ansMax;
    }


    public static void main(String[] args) {
        System.out.println("hello");
    }

}
