package contest.contest408;

import java.util.Arrays;
import java.util.Comparator;

public class D {

    private boolean isInCircle(long x, long y, long r, long X, long Y) {
        return (x - X) * (x - X) + (y - Y) * (y -Y) <= r * r;
    }

    public boolean canReachCorner(int X, int Y, int[][] circles) {
        int len = circles.length;
        if (len == 1) {
            int[] circle = circles[0];
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            boolean notOk =  x - r <= 0 && x + r >= X     // x撑满
                    || y - r <= 0 && y + r >= Y // y撑满
                    || x - r <= 0 && y - r <= 0 // 把（0，0）堵住了
                    || x <= X && x + r >= X && y <= Y && y + r >= Y  // 把（X,Y）堵住了
                    || isInCircle(x, y, r, X, Y) // 圆包含(X, Y)
                    || isInCircle(x, y, r, 0, 0); // 圆包含(0, 0)
            return !notOk;
        }

        // 判断(0, 0) 和 （X, Y）是否在任意一个圆内
        for (int i = 0; i < len; i++) {
            int[] circle = circles[i];
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            if (isInCircle(x, y , r, 0, 0) || isInCircle(x, y, r, X, Y)) {
                return false;
            }
        }

        // (0, 0) 和 （X, Y）都不在任意一个圆内
        Arrays.sort(circles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 按圆心坐标X升序
                return o1[0] - o1[2] - (o2[0] - o2[2]);
            }
        });

        // 从左向右遍历，看X是否把撑满了
        long firstCircleX = circles[0][0];
        long firstCircleR = circles[0][2];
        if (firstCircleX - firstCircleR <= 0) {
            long leftCircleX = firstCircleX;
            long leftCircleY = circles[0][1];
            long leftCircleR = firstCircleR;
            boolean isXFull = true;
            int[] lastCircle = circles[0];
            for (int i = 1; i < len; i++) {
                int[] circle = circles[i];
                long x = circle[0];
                long y = circle[1];
                long r = circle[2];
                if ((x - leftCircleX) * (x - leftCircleX) + (y - leftCircleY) * (y - leftCircleY) > (leftCircleR + r) * (leftCircleR + r)) {
                    leftCircleX = x;
                    leftCircleR = r;
                    if (x - r > 0) {
                        isXFull = false;
                        break;
                    }
                    continue;
                }

                lastCircle = circle;

                if (y - r <= 0) {
                    return false;
                }

                leftCircleX = x;
                leftCircleR = r;
            }

            // 如果最后一个圆的右边界 >= X, 则说明X撑满了
            if (isXFull && lastCircle[0] + lastCircle[2] >= X) {
                return false;
            }
        }

        Arrays.sort(circles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 按圆心坐标X升序
                return (o1[1] - o1[2]) - (o2[1] - o2[2]);
            }
        });

        // 从上到下
        long firstCircleY = circles[len - 1][1];
        firstCircleR = circles[len - 1][2];
        if (firstCircleY + firstCircleR >= Y) {
            long topCircleX = circles[len - 1][0];
            long topCircleY = firstCircleY;
            long topCircleR = firstCircleR;
            boolean isYFull = true;
            int[] lastCircle = circles[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                int[] circle = circles[i];
                long x = circle[0];
                long y = circle[1];
                long r = circle[2];
                if ((x - topCircleX) * (x - topCircleX) + (y - topCircleY) * (y - topCircleY) > (topCircleR + r) * (topCircleR + r)) {
                    topCircleY = y;
                    topCircleR = r;
                    if (y + r < Y) {
                        isYFull = false;
                        break;
                    }
                    continue;
                }
                lastCircle = circle;

                if (x + r >= X) {
                    return false;
                }

                topCircleY = y;
                topCircleR = r;
            }

            // 如果第一个圆的下边界 <= 0, 则说明Y撑满了
            if (isYFull && lastCircle[1] - lastCircle[2] <= 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(new D().canReachCorner(8, 9, new int[][]{
                {3,1,1,}, {1,5,1}, {4,8,2}
        }));
    }

}
