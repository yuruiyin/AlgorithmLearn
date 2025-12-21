package doubleContest.round172;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class B {

    public int maximumSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<Integer>[] listArr = new ArrayList[3];
        Arrays.setAll(listArr, value -> new ArrayList<>());
        for (int i = len - 1; i >= 0; i--) {
            int mod = nums[i] % 3;
            listArr[mod].add(nums[i]);
        }

        // 0 + 0 + 0
        long sum000 = 0;
        if (listArr[0].size() >= 3) {
            sum000 = listArr[0].get(0) + listArr[0].get(1) + listArr[0].get(2);
        }

        // 0 + 1 + 2
        long sum012 = 0;
        if (listArr[0].size() >= 1 && listArr[1].size() >= 1 && listArr[2].size() >= 1) {
            sum012 = listArr[0].get(0) + listArr[1].get(0) + listArr[2].get(0);
        }

        // 1 + 1 + 1
        long sum111 = 0;
        if (listArr[1].size() >= 3) {
            sum111 = listArr[1].get(0) + listArr[1].get(1) + listArr[1].get(2);
        }

        // 2 + 2 + 2
        long sum222 = 0;
        if (listArr[2].size() >= 3) {
            sum222 = listArr[2].get(0) + listArr[2].get(1) + listArr[2].get(2);
        }

        return (int) Math.max(Math.max(sum000, sum012), Math.max(sum111, sum222));
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
