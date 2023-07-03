package doubleContest.round101;

import java.util.Arrays;

public class A {

    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        boolean[] visited1 = new boolean[10];
        for (int num : nums1) {
            visited1[num] = true;
        }

        boolean[] visited2 = new boolean[10];
        for (int num : nums2) {
            visited2[num] = true;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited1[i] && visited2[i]) {
                return i;
            }
        }

        return Math.min(nums1[0] * 10 + nums2[0], nums2[0] * 10 + nums1[0]);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
