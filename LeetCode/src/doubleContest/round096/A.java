package doubleContest.round096;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        int ansMin = Integer.MAX_VALUE;
        for (int num1 : set1) {
            if (set2.contains(num1)) {
                ansMin = Math.min(ansMin, num1);
            }
        }

        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
