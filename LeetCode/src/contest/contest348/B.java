package contest.contest348;

public class B {

    public int semiOrderedPermutation(int[] nums) {
        int i1 = -1;
        int in = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                i1 = i;
            } else if (nums[i] == len) {
                in = i;
            }
        }

        if (in > i1) {
            return i1 + len - 1 - in;
        }

        return i1 + len - 1 - in - 1;
    }

}
