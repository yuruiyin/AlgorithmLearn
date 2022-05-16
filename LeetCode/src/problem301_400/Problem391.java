package problem301_400;

public class Problem391 {

    private int getArea(int[] rec) {
        return (rec[2] - rec[0]) * (rec[3] - rec[1]);
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int totalAreaSum = 0;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int[] rec : rectangles) {
            totalAreaSum += getArea(rec);
            minX = Math.min(minX, rec[0]);
            minY = Math.min(minY, rec[1]);
            maxX = Math.max(maxX, rec[2]);
            maxY = Math.max(maxY, rec[3]);
        }

        return (maxX - minX) * (maxY - minY) == totalAreaSum;
    }

}
