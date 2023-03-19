package contest.contest336;

import java.util.Arrays;

public class B {

    private void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }


    public int maxScore(int[] nums) {
        sortDesc(nums);
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        int ans = preSumArr[0] > 0 ? 1: 0;
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
            ans += preSumArr[i] > 0 ? 1: 0;
        }
        return ans;
    }

}
