package contest.contest215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/15
 */
public class B {

    private int[] getCountArr(char[] arr) {
        int[] countArr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - 'a']++;
        }

        return countArr;
    }

    private List<Integer> getCountList(int[] countArr) {
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0) {
                ansList.add(countArr[i]);
            }
        }

        return ansList;
    }

    public boolean closeStrings(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        if (arr1.length != arr2.length) {
            return false;
        }

        int len = arr1.length;

        if (Arrays.equals(arr1, arr2)) {
            return true;
        }

        int[] countArr1 = getCountArr(arr1);
        int[] countArr2 = getCountArr(arr2);

        for (int i = 0; i < 26; i++) {
            if (countArr1[i] == 0 && countArr2[i] != 0 || countArr1[i] != 0 && countArr2[i] == 0) {
                return false;
            }
        }

        List<Integer> countList1 = getCountList(countArr1);
        List<Integer> countList2 = getCountList(countArr2);

        Collections.sort(countList1);
        Collections.sort(countList2);

        return countList1.equals(countList2);
    }

}
