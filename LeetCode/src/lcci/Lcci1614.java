package lcci;

public class Lcci1614 {

    public int[] bestLine(int[][] points) {
        int[] ansArr = new int[2];
        int len = points.length;

        int maxPointCount = 0;

        for (int i = 0; i < len; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < len; j++) {
                int[] point2 = points[j];
                double slope = point1[0] == point2[0] ? Double.MAX_VALUE : (point2[1] - point1[1]) * 1.0 / (point2[0] - point1[0]);
                int count = 2;
                for (int k = j + 1; k < len; k++) {
                    int[] curPoint = points[k];
                    double curSlope = point1[0] == curPoint[0] ? Double.MAX_VALUE :
                            (curPoint[1] - point1[1]) * 1.0 / (curPoint[0] - point1[0]);
                    if (curSlope == slope) {
                        count++;
                    }
                }

                if (count > maxPointCount) {
                    maxPointCount = count;
                    ansArr = new int[]{i, j};
                }
            }
        }

        return ansArr;
    }

}
