package contest.contest406;

import utils.TreeMultiSet;

import java.util.*;

public class D {

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        sortDesc(horizontalCut);
        sortDesc(verticalCut);
        long hCount = 1;
        long vCount = 1;
        long ans = 0;
        int i = 0;
        int j = 0;
        while (i < horizontalCut.length && j < verticalCut.length) {
            if (horizontalCut[i] > verticalCut[i]) {
                // 水平切割
                ans += horizontalCut[i] * vCount;
                hCount++;
                i++;
            } else {
                ans += verticalCut[j] * hCount;
                vCount++;
                j++;
            }
        }

        while (i < horizontalCut.length) {
            ans += horizontalCut[i] * vCount;
            hCount++;
            i++;
        }

        while (j < verticalCut.length) {
            ans += verticalCut[j] * hCount;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));
    }

}
