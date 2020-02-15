package lcci;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcci0806 {

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
            return;
        }
        move(n-1, A, C, B);
        C.add(A.get(A.size() - 1));
        A.remove(A.size() - 1);
        move(n-1, B, A, C);
    }

    public void hanota(int[] A, int[] B, int[] C) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            C[i] = A[i];
        }
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        List<Integer> cList = new ArrayList<>();
        for (int num : A) {
            aList.add(num);
        }
        move(n, aList, bList, cList);
//        C = new int[n];
        for (int i = 0; i < n; i++) {
            C[i] = cList.get(i);
        }

//        PrintUtil.printIntArray(C);
    }
    
    public static void main(String[] args) {
        new Lcci0806().hanota(new int[]{2, 1, 0}, new int[3], new int[3]);
    }

}
