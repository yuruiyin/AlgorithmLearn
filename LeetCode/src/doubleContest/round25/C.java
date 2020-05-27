package doubleContest.round25;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/2
 */
public class C {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;

        boolean isOk = true;
        for (int i = 0; i < n; i++) {
            if (arr1[i] > arr2[i]) {
                isOk = false;
                break;
            }
        }

        if (isOk) {
            return true;
        }

        isOk = true;
        for (int i = 0; i < n; i++) {
            if (arr1[i] < arr2[i]) {
                isOk = false;
                break;
            }
        }

        return isOk;
    }

}
