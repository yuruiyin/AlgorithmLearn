package contest.contest424;

import java.util.Arrays;

public class A {

    private boolean isOk(int curr, boolean isLeft, int[] nums, int n) {
        int[] ansArr = Arrays.copyOf(nums, n);
        while (curr >= 0 && curr <= n - 1) {
            if (ansArr[curr] == 0) {
                if (isLeft) {
                    curr--;
                } else {
                    curr++;
                }
            } else {
                ansArr[curr]--;
                isLeft = !isLeft;
                if (isLeft) {
                    curr--;
                } else {
                    curr++;
                }
            }
        }

        for (int num: ansArr) {
            if (num > 0) {
                return false;
            }
        }

        return true;
    }

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ansCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            }

            // 向左
            boolean isOkk = isOk(i, true, nums, n);
            if (isOkk) {
                ansCount++;
            }

            // 向右
            isOkk = isOk(i, false, nums, n);
            if (isOkk) {
                ansCount++;
            }
        }

        return ansCount;
    }

    public static void main(String[] args) {

    }

}
