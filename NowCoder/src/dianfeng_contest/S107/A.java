package dianfeng_contest.S107;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int[] sovle (int[] a, int n, int m) {
        // write code here
        int len = a.length;
        int[] oldArr = Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        int nNum = a[len - n];
        int mNum = a[len - m];
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < len; i++) {
            if (oldArr[i] == nNum) {
                index1 = i;
            } else if (oldArr[i] == mNum) {
                index2 = i;
            }
        }

        swap(oldArr, index1, index2);
        return oldArr;
    }

}
