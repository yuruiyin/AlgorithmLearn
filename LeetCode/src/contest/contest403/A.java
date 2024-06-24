package contest.contest403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class A {

    public double minimumAverage(int[] nums) {
        int n = nums.length;
        int count = n / 2;
        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;
        List<Double> list = new ArrayList<>();
        while (l < r) {
            list.add((nums[l] + nums[r]) / 2.0);
            l++;
            r--;
        }

        double min = Double.MAX_VALUE;
        for (double num : list) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
