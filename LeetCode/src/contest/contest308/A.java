package contest.contest308;

import java.util.Arrays;

public class A {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] ansArr = new int[queries.length];
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int resLen = 0;
            for (int j = 0; j < len; j++) {
                if (preSumArr[j] > queries[i]) {
                    break;
                }
                resLen = j + 1;
            }
            ansArr[i] = resLen;
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
