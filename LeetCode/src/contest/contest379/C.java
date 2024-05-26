package contest.contest379;

import java.util.*;

public class C {

    public int maximumSetSize(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        int half = n / 2;
        int size1 = set1.size();
        int size2 = set2.size();
        int count1 = 0;
        Set<Integer> leftSet = new HashSet<>();
        int leftCount1 = 0;
        for (int num1: set1) {
            if (!set2.contains(num1)) {
                count1++;
            }
        }

        for (int num1: set1) {
            if (set2.contains(num1)) {
                if (leftSet.size() + count1 < half) {
                    leftSet.add(num1);
                }
            }
        }

        int ans = Math.min(half, count1);

        int count2 = 0;
        int leftCount2 = 0;
        for (int num2: set2) {
            if (!set1.contains(num2)) {
                count2++;
            }
        }

        for (int num2: set2) {
            if (set1.contains(num2)) {
                if (leftCount2 + count2 < half) {
                    if (!leftSet.contains(num2)) {
                        leftCount2++;
                        leftSet.add(num2);
                    }
                }
            }
        }

        ans += Math.min(half, count2);
        if (ans == n) {
            return n;
        }

        return ans + leftSet.size();



//        if (size1 <= half && size2 <= half)  {
//            set.addAll(set1);
//            set.addAll(set2);
//            return set.size();
//        } else if (size1 > half && size2 <= half) {
//            set.addAll(set2);
//            int count = 0;
//            for (int num1 : set1) {
//                if (set.contains(num1)) {
//                    continue;
//                }
//                set.add(num1);
//                count++;
//                if (count == half) {
//                    break;
//                }
//            }
//            return set.size();
//        } else if (size1 <= half && size2 > half) {
//            set.addAll(set1);
//            int count = 0;
//            for (int num2 : set2) {
//                if (set.contains(num2)) {
//                    continue;
//                }
//                set.add(num2);
//                count++;
//                if (count == half) {
//                    break;
//                }
//            }
//        } else {
//            // size1 > half && size2 > half
//            for (int i = )
//        }
    }

}
