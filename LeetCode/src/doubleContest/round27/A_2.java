package doubleContest.round27;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/30
 */
public class A_2 {

    private int[] getCountArr(int[] arr) {
        int[] countArr = new int[1001];
        for (int num : arr) {
            countArr[num]++;
        }
        return countArr;
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] countArr1 = getCountArr(arr);
        int[] countArr2 = getCountArr(target);
        return Arrays.equals(countArr1, countArr2);
    }

}
