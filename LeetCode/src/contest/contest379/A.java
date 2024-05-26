package contest.contest379;

public class A {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int max = 0;
        for (int[] dimen: dimensions) {
            int w = dimen[0];
            int h = dimen[1];
            int value = w * w + h * h;
            if (value > max) {
                max = value;
                maxArea = w * h;
            } else if (value == max && w * h > maxArea) {
                maxArea = w * h;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
