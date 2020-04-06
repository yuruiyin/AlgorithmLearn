package doubleContest.round23;

import com.sun.source.tree.BreakTree;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class C {

    private boolean isIn(int x1, int y1, int x2, int y2, int radius) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= radius * radius;
    }

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        // 先判断圆形是否在正方形内
        if (x_center >= x1 && x_center <= x2 && y_center >= y1 && y_center <= y2) {
            return true;
        }

        if (x_center - radius > x2 || x_center + radius < x1 || y_center + radius < y1 || y_center - radius > y2) {
            return false;
        }

        // 正方形有点在圆内
        if (isIn(x_center, y_center, x1, y1, radius) || isIn(x_center, y_center, x2, y2, radius) ||
                isIn(x_center, y_center, x1, y2, radius) ||isIn(x_center, y_center, x2, y1, radius)) {
            return true;
        }

        if (y_center >= y1 && y_center <= y2 || x_center >= x1 && x_center <= x2) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new C().checkOverlap(1, 1, 1, -3, -3, 3, 3));
    }

}
