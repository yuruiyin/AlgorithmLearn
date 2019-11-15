package contest.contest134;

import java.util.ArrayList;
import java.util.List;

public class Problem1035 {

    private List<Integer>[] numIndexList1;
    private List<Integer>[] numIndexList2;
    private int[] arr1;
    private int[] arr2;
    private int len1;
    private int len2;
    private int[][] memo;

    private int backTrack(int from1, int from2) {
        if (from1 == len1 || from2 == len2) {
            return 0;
        }

        if (memo[from1][from2] != -1) {
            return memo[from1][from2];
        }

        int num1 = arr1[from1];
        if (numIndexList2[num1].isEmpty()) {
            memo[from1][from2] = backTrack(from1+1, from2);
            return memo[from1][from2];
        }

        int index2 = -1;
        for (Integer index: numIndexList2[num1]) {
            if (index < from2) {
                continue;
            }

            index2 = index;
            break;
        }

        if (index2 == -1) {
            memo[from1][from2] = backTrack(from1+1, from2);
            return memo[from1][from2];
        }

        // 分为不连和连两种
        int nonConnectRes = backTrack(from1+1, from2);
        int connectRes = backTrack(from1+1, index2 + 1) + 1;

        int max = Math.max(nonConnectRes, connectRes);
        memo[from1][from2] = max;

        return max;
    }

    public int maxUncrossedLines(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        len1 = arr1.length;
        len2 = arr2.length;
        numIndexList1 = new ArrayList[2001];
        numIndexList2 = new ArrayList[2001];

        for (int i = 1; i <= 2000; i++) {
            numIndexList1[i] = new ArrayList<>();
            numIndexList2[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr1.length; i++) {
            numIndexList1[arr1[i]].add(i);
        }

        for (int i = 0; i < arr2.length; i++) {
            numIndexList2[arr2[i]].add(i);
        }

        memo = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                memo[i][j] = -1;
            }
        }
        return backTrack(0, 0);
    }
    
    public static void main(String[] args) {
        
    }
    
}
