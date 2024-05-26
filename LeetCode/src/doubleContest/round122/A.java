package doubleContest.round122;

import java.util.Arrays;

public class A {

    public int minimumCost(int[] nums) {
        int ans = nums[0];
        int len = nums.length;
        int[] arr = new int[len - 1];
        for (int i = 1; i < nums.length; i++) {
            arr[i - 1] = nums[i];
        }
        Arrays.sort(arr);

        return ans + arr[0] + arr[1];
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
