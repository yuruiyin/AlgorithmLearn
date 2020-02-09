package contest.contest116;

public class Problem963 {

    private int[][] points;

    private boolean isVertical(int i, int j, int k) {
        return  (points[j][1] - points[i][1]) * (points[k][1] - points[j][1]) ==
                -(points[j][0] - points[i][0]) * (points[k][0] - points[j][0]);
    }

    public double minAreaFreeRect(int[][] points) {
        this.points = points;
        int len = points.length;
        double[][] slideLenArr = new double[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                slideLenArr[i][j] = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) * 1.0 +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
            }
        }

        double minArea = Double.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                double slideLen1 = slideLenArr[i][j];
                for (int k = 0; k < len; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    double slideLen2 = slideLenArr[j][k];
                    if (!isVertical(i, j, k)) {
                        continue;
                    }

                    for (int l = 0; l < len; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        double slideLen3 = slideLenArr[k][l];
                        if (slideLen1 != slideLen3) {
                            continue;
                        }

                        if (!isVertical(j, k, l)) {
                            continue;
                        }

                        double slideLen4 = slideLenArr[l][i];
                        if (slideLen2 != slideLen4) {
                            continue;
                        }

                        if (!isVertical(k, l, i)) {
                            continue;
                        }

                        double tmpArea = Math.sqrt(slideLen1) * Math.sqrt(slideLen2);
                        minArea = Math.min(minArea, tmpArea);
                    }
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }

    public static void main(String[] args) {
        System.out.println(new Problem963().minAreaFreeRect(new int[][]{
                {1,2},{2,1},{1,0},{0,1}
        }));
    }

}
