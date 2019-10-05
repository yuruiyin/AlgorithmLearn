public class Problem219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;

        if (len <= 1 || k <= 0) {
            return false;
        }

        int left = 0;
        int right = 1;

        while (left <= right && right - left <= k && right < len) {
            if (nums[left] == nums[right] && left < right) {
                return true;
            }

            if (right - left == k || right == len - 1) {
                left++;
            } else {
                right++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean ans = new Problem219().containsNearbyDuplicate(new int[]{1,2,3,1}, 3);
        System.out.println(ans);

        boolean ans1 = new Problem219().containsNearbyDuplicate(new int[]{1,0,1,1}, 1);
        System.out.println(ans1);

        boolean ans2 = new Problem219().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
        System.out.println(ans2);

        boolean ans3 = new Problem219().containsNearbyDuplicate(new int[]{99,99}, 2);
        System.out.println(ans3);

        boolean ans4 = new Problem219().containsNearbyDuplicate(new int[]{1,2,3,4,5,6,7,8,9,9}, 3);
        System.out.println(ans4);
    }
}
