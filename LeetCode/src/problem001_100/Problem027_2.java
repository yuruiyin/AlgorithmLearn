package problem001_100;

/**
 * Problem027_2
 *
 * @author: yry
 * @date: 2021/5/6
 */
public class Problem027_2 {

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
