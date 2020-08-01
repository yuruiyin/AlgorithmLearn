package doubleContest.round29;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/27
 */
public class C {

    public int longestSubarray(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return 0;
        }

        int[] preOneCountArr = new int[len];
        preOneCountArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == 0) {
                preOneCountArr[i] = 0;
            } else {
                preOneCountArr[i] = preOneCountArr[i-1] + 1;
            }
        }

        int[] sufOneCountArr = new int[len];
        sufOneCountArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                sufOneCountArr[i] = 0;
            } else {
                sufOneCountArr[i] = sufOneCountArr[i + 1] + 1;
            }
        }

        int ansMax = 0;
        boolean hasZero = false;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                if (i == 0) {
                    ansMax = Math.max(ansMax, sufOneCountArr[i + 1]);
                } else if (i == len - 1) {
                    ansMax = Math.max(ansMax, preOneCountArr[i-1]);
                } else {
                    ansMax = Math.max(ansMax, preOneCountArr[i-1] + sufOneCountArr[i + 1]);
                }
                hasZero = true;
            }
        }

        return hasZero ? ansMax : len - 1;
    }

}
