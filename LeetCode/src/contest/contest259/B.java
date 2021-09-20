package contest.contest259;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/19
 */
public class B {

    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        int[] preMaxArr = new int[len];
        preMaxArr[0] = nums[0];
        int[] sufMinArr = new int[len];
        sufMinArr[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            preMaxArr[i] = Math.max(preMaxArr[i - 1], nums[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            sufMinArr[i] = Math.min(sufMinArr[i + 1], nums[i]);
        }

        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            if (preMaxArr[i - 1] < nums[i] && nums[i] < sufMinArr[i + 1]) {
                sum += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                sum++;
            }
        }
        return sum;
    }

}
