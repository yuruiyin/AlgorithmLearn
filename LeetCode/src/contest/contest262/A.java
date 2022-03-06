package contest.contest262;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/10
 */
public class A {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] countArr = new int[101];
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : set1) {
            countArr[num]++;
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        for (int num : set2) {
            countArr[num]++;
        }

        Set<Integer> set3 = new HashSet<>();
        for (int num : nums3) {
            set3.add(num);
        }

        for (int num : set3) {
            countArr[num]++;
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (countArr[i] >= 2) {
                ansList.add(i);
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
