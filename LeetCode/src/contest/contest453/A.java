package contest.contest453;

import java.util.Arrays;

public class A {

    public boolean canMakeEqual(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        for (int target = -1; target <= 1; target+= 2) {
            int count = 0;
            boolean isOk = true;
            int[] tmpNums = Arrays.copyOf(nums, len);
            for (int i = 0; i < len - 1; i++) {
                if (tmpNums[i] != target) {
                    if (count == k) {
                        isOk = false;
                        break;
                    }
                    count++;
                    tmpNums[i] = -tmpNums[i];
                    tmpNums[i + 1] = -tmpNums[i + 1];
                }
            }

            if (isOk && tmpNums[len - 2] == tmpNums[len - 1]) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
