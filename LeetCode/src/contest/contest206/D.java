package contest.contest206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/13
 */
public class D {

    private int[] getCountArr(char[] arr) {
        int[] countArr = new int[10];
        for (char c : arr) {
            countArr[c - '0']++;
        }
        return countArr;
    }

    public boolean isTransformable(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int len = arr1.length;

        int[] countArr1 = getCountArr(arr1);
        int[] countArr2 = getCountArr(arr2);
        if (!Arrays.equals(countArr1, countArr2)) {
            return false;
        }

        LinkedList<Integer>[] indexListArr = new LinkedList[10];
        for (int i = 0; i < len; i++) {
            int c = arr1[i] - '0';
            if (indexListArr[c] == null) {
                indexListArr[c] = new LinkedList<>();
            }
            indexListArr[c].add(i);
        }

        for (int i = len - 1; i >= 0; i--) {
            if (arr1[i] == arr2[i]) {
                indexListArr[arr1[i] - 'c'].removeLast();
                continue;
            }

            char target = arr2[i];
            LinkedList<Integer> indexList = indexListArr[target - '0'];
            int index = indexList.getLast();
            for (int j = index; j < i; j++) {
                if (arr1[j] < arr1[j+1]) {
                    return false;
                }

                char tmp = arr1[j];
                arr1[j] = arr1[j + 1];
                arr1[j + 1] = tmp;
            }

            indexList.removeLast();
        }

        return true;
    }

}
