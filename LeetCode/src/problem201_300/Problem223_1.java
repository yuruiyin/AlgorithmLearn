package problem201_300;

import java.util.Arrays;

public class Problem223_1 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        if (E >= C || G <= A || H <= B || F >= D) {
            // 不相交
            return area1 + area2;
        }

        // x轴和y轴坐标分别从小到大排序，相交的矩形就是由中间两个点构成的
        int[] xArr = new int[]{A, C, E, G};
        int[] yArr = new int[]{B, D, F, H};
        Arrays.sort(xArr);
        Arrays.sort(yArr);
        int commonArea = (xArr[2] - xArr[1]) * (yArr[2] - yArr[1]);
        return area1 + area2 - commonArea;
    }

}
