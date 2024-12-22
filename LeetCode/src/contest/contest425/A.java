package contest.contest425;

import java.util.List;
import java.util.Map;

public class A {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ansMin = Integer.MAX_VALUE;
        for (int len = l; len <= r; len++) {
            for (int i = 0; i <= nums.size() - len; i++) {
                int sum = 0;
                for (int j = i; j < i + len; j++) {
                    sum += nums.get(j);
                }
                if (sum > 0) {
                    ansMin = Math.min(ansMin, sum);
                }
            }
        }
        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }


    public static void main(String[] args) {
        System.out.println("hello");
    }

}
