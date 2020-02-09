package problem901_1000;

import java.util.ArrayList;
import java.util.List;

public class Problem986 {

    public int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval1 : arr1) {
            int start1 = interval1[0];
            int end1 = interval1[1];
            for (int[] interval2: arr2) {
                int start2 = interval2[0];
                int end2 = interval2[1];

                if (start2 > end1) {
                    break;
                }

                int maxStart = Math.max(start1, start2);
                int minEnd = Math.min(end1, end2);
                if (minEnd >= maxStart) {
                    ansList.add(new int[]{maxStart, minEnd});
                }
            }
        }

        int size = ansList.size();
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

}
