package problem801_900;

public class Problem812 {

    private double calcArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            double x1 = points[i][0];
            double y1 = points[i][1];
            for (int j = i + 1; j < len; j++) {
                double x2 = points[j][0];
                double y2 = points[j][1];
                double a = Math.sqrt((x1 - x2) * (x1 - x2) - (y1 - y2) * (y1 - y2));
                for (int k = j + 1; k < len; k++) {
                    double x3 = points[k][0];
                    double y3 = points[k][1];
                    double b = Math.sqrt((x1 - x3) * (x1 - x3) - (y1 - y3) * (y1 - y3));
                    double c = Math.sqrt((x2 - x3) * (x2 - x3) - (y2 - y3) * (y2 - y3));
                    double area = calcArea(a, b, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

}
