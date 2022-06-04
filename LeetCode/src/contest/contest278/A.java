package contest.contest278;

public class A {

    public int findFinalValue(int[] nums, int original) {
        while (true) {
            boolean isFound = false;
            for (int num : nums) {
                if (num == original) {
                    original <<= 1;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                return original;
            }
        }
    }

}
