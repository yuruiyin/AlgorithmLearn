package contest.contest290;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class C {

    private int findFirstBiggerOrEqual(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target <= list.get(mid)) {
                if (mid == 0 || target > list.get(mid - 1)) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] xListArr = new ArrayList[101];
        for (int[] r : rectangles) {
            int x = r[0];
            int y = r[1];
            if (xListArr[y] == null) {
                xListArr[y] = new ArrayList<>();
            }
            xListArr[y].add(x);
        }

        for (int i = 1; i <= 100; i++) {
            List<Integer> xList = xListArr[i];
            if (xList != null) {
                Collections.sort(xList);
            }
        }

        int[] ansArr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            int count = 0;
            for (int yy = y; yy <= 100; yy++) {
                List<Integer> xList = xListArr[yy];
                if (xList == null) {
                    continue;
                }
                int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(xList, x);
                if (firstBiggerOrEqualIdx != -1) {
                    count += xList.size() - firstBiggerOrEqualIdx;
                }
            }
            ansArr[i] = count;
        }
        return ansArr;
    }

}
