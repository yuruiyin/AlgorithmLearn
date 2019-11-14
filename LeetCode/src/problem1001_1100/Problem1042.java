package problem1001_1100;

import utils.PrintUtil;

import java.util.*;

public class Problem1042 {

    public int[] gardenNoAdj(int n, int[][] paths) {
        if (n == 1) {
            return new int[]{1};
        }

        List<Integer>[] adj = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] path: paths) {
            int first = path[0];
            int second = path[1];
            adj[first].add(second);
            adj[second].add(first);
        }

        int[] colorArr = new int[n];
        for (int i = 1; i <= n; i++) {
            Set<Integer> colorSet = new HashSet<>(Arrays.asList(1,2,3,4));
            for (Integer neighbor: adj[i]) {
                if (colorArr[neighbor-1] != 0) {
                    colorSet.remove(colorArr[neighbor-1]);
                }
            }

            colorArr[i-1] = colorSet.iterator().next();
        }

        return colorArr;
    }

    public static void main(String[] args) {
        int[] arr = new Problem1042().gardenNoAdj(6, new int[][]{
                {6,4},{6,1},{3,1},{4,5},{2,1},{5,6},{5,2}
        });

        PrintUtil.printIntArray(arr);
    }
}
