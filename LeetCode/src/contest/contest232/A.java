package contest.contest232;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/14
 */
public class A {

    public boolean areAlmostEqual(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int len = arr1.length;
        int diffCount = 0;
        for (int i = 0; i < len; i++) {
            if (arr1[i] != arr2[i]) {
                diffCount++;
            }
        }

        if (diffCount == 0) {
            return true;
        }

        if (diffCount == 2) {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            return Arrays.equals(arr1, arr2);
        }

        return false;

    }

}
