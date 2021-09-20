package problem001_100;

/**
 * Problem027
 *
 * @author: yry
 * @date: 2021/5/6
 */
public class Problem027_1 {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int r = len - 1;
        while (l < r) {
            while (nums[l] != val && l < r) {
                l++;
            }

            if (nums[r] != val) {
                nums[l] = nums[r];
            }
            r--;
        }

        return nums[l] == val ? l : l + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem027_1().removeElement(new int[]{3, 2, 2, 3}, 3));
    }

}
