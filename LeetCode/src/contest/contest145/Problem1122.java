package contest.contest145;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] ansArr = new int[len1];
        int[] countArr1 = new int[1001];
        int[] countArr2 = new int[1001];
        List<Integer> otherList = new ArrayList<>();

        for (int num: arr2) {
            countArr2[num]++;
        }

        for (int num: arr1) {
            if (countArr2[num] == 0) {
                otherList.add(num);
            } else {
                countArr1[num]++;
            }
        }

        List<Integer> tmpList = new ArrayList<>();
        for (int num: arr2) {
            while ((countArr1[num]--) > 0) {
                tmpList.add(num);
            }
        }

        Collections.sort(otherList);
        tmpList.addAll(otherList);

        for (int i = 0; i < len1; i++) {
            ansArr[i] = tmpList.get(i);
        }

        return  ansArr;
    }
    
    public static void main(String[] args) {
        int[] ans = new Problem1122().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
        PrintUtil.printIntArray(ans);
    }
    
}
