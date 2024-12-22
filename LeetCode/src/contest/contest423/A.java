package contest.contest423;

import java.util.*;

public class A {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k == 1) {
            return true;
        }
        int len = nums.size();
        for (int i = 0; i <= len - 2 * k; i++) {
            boolean isOk = true;
            for (int l = i + 1; l < i + k; l++) {
                if (nums.get(l) <= nums.get(l - 1)) {
                    isOk = false;
                    break;
                }
            }
            if (!isOk) {
                continue;
            }

            for (int l = i + k + 1; l < i + 2 * k ; l++) {
                if (nums.get(l) <= nums.get(l - 1)) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
