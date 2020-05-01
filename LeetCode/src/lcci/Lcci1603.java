package lcci;

import java.util.*;

/**
 * Lcci1603
 *
 * @author: yry
 * @date: 2020/4/12
 */
public class Lcci1603 {

    private double dis(double x1, double y1, double x2, double y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    private boolean isLineSlopeEqual(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        return (x2 - x1) * (y4 - y3) == (x4 - x3) * (y2 - y1);
    }

    // 思路
    // 1、先把两条线段当成直线，求两条直线的交点，若两条直线斜率一样，则平行，没有交点
    // 2、假设求得交点为(x, y)，然后分别计算交点到两条线段两个断点的距离，如果两条线段有交点
    //    那么，交点到两条线段的端点的距离一定都小于两条线段的长度
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0];
        int y1 = start1[1];
        int x2 = end1[0];
        int y2 = end1[1];

        int x3 = start2[0];
        int y3 = start2[1];
        int x4 = end2[0];
        int y4 = end2[1];

        // 若两条线段有交点，那么交掉到四个点的距离必须小于线段的长度
        double len1 = dis(x1, y1, x2, y2);
        double len2 = dis(x3, y3, x4, y4);

        if (isLineSlopeEqual(x1, y1, x2, y2, x3, y3, x4, y4)) {
            // 斜率相等，平行，无交点
            // 分两种情况，线段重叠，和线段不重叠
            List<double[]> list = new ArrayList<>();
            if (isLineSlopeEqual(x1, y1, x3, y3, x3, y3, x4, y4) && dis(x1, y1, x3, y3) <= len2 && dis(x1, y1, x4, y4) <= len2) {
                list.add(new double[]{x1, y1});
            }

            if (isLineSlopeEqual(x2, y2, x3, y3, x3, y3, x4, y4) && dis(x2, y2, x3, y3) <= len2 && dis(x2, y2, x4, y4) <= len2) {
                list.add(new double[]{x2, y2});
            }

            if (isLineSlopeEqual(x3, y3, x1, y1, x1, y1, x2, y2) && dis(x3, y3, x1, y1) <= len1 && dis(x3, y3, x2, y2) <= len1) {
                list.add(new double[]{x3, y3});
            }

            if (isLineSlopeEqual(x4, y4, x1, y1, x1, y1, x2, y2) &&dis(x4, y4, x1, y1) <= len1 && dis(x4, y4, x2, y2) <= len1) {
                list.add(new double[]{x4, y4});
            }

            if (list.isEmpty()) {
                return new double[0];
            }

            // 线段重叠
            list.sort((o1, o2) -> Double.compare(o1[0], o2[0]) == 0 ?
                    Double.compare(o1[1], o2[1]) : Double.compare(o1[0], o2[0]));

            return new double[]{list.get(0)[0], list.get(0)[1]};
        }

        double a1 = y2 - y1;
        double b1 = x1 - x2;
        double c1 = x1 * y2 - x2 * y1;
        double a2 = y4 - y3;
        double b2 = x3 - x4;
        double c2 = x3 * y4 - x4 * y3;
        double delta = a1 * b2 - a2 * b1;

        // 交点坐标
        double x = (c1 * b2 - c2 * b1) / delta;
        double y = (a1 * c2 - a2 * c1) / delta;

        boolean hasIntersection = dis(x, y, x1, y1) <= len1 && dis(x, y, x2, y2) <= len1 &&
                dis(x, y, x3, y3) <= len2 && dis(x, y, x4, y4) <= len2;

        return hasIntersection ? new double[]{x, y} : new double[0];
    }

    public static void main(String[] args) {
        double[] ans = new Lcci1603().intersection(new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 0}, new int[]{0, -1});
        System.out.println(Arrays.toString(ans));
    }

}
