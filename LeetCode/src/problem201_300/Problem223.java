package problem201_300;

public class Problem223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        if (E >= C || G <= A || H <= B || F >= D) {
            // 不相交
            return area1 + area2;
        }

        int leftBottomX = Math.max(A, E);
        int leftBottomY = Math.max(B, F);
        int rightUpX = Math.min(C, G);
        int rightUpY = Math.min(D, H);
        int commonArea = (rightUpX - leftBottomX) * (rightUpY - leftBottomY);
        return area1 + area2 - commonArea;
    }

}
