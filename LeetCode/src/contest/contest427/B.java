package contest.contest427;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B {

    private int len;

    private int[][] points;

    private int[] isValidRect(int[][] points, int i, int j, int k, int l) {
        List<int[]> list = new ArrayList<>();
        list.add(points[i]);
        list.add(points[j]);
        list.add(points[k]);
        list.add(points[l]);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        boolean[] visited = new boolean[points.length];
        visited[i] = true;
        visited[j] = true;
        visited[k] = true;
        visited[l] = true;

        if (list.get(0)[0] == list.get(1)[0]
                && list.get(0)[1] == list.get(2)[1]
                && list.get(2)[0] == list.get(3)[0]
                && list.get(1)[1] == list.get(3)[1]) {
            int minX = list.get(0)[0];
            int maxX = list.get(2)[0];
            int minY = list.get(0)[1];
            int maxY = list.get(3)[1];
            for (int ii = 0; ii < points.length; ii++) {
                if (visited[ii]) {
                    continue;
                }

                int[] point = points[ii];
                int x = point[0];
                int y = point[1];
                if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
                    return null;
                }
            }

            return new int[]{maxX - minX, maxY - minY};
        }

        return null;
    }

    public int maxRectangleArea(int[][] points) {
        this.len = points.length;
        int maxArea = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int l = k + 1; l < len; l++) {
                        int[] side = isValidRect(points, i, j, k, l);
                        if (side != null) {
                            maxArea = Math.max(maxArea, side[0] * side[1]);
                        }
                    }
                }
            }
        }
        return maxArea;
    }

}
