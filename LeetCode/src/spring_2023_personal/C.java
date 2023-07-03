package spring_2023_personal;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C {

    static class Rectangle {
        // 左下角坐标
        double x;
        double y;
        double height;
        double width;

        Rectangle(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public static Rectangle getIntersection(Rectangle rect1, Rectangle rect2) {
        double x1 = rect1.x;
        double y1 = rect1.y;
        double x2 = rect1.x + rect1.width;
        double y2 = rect1.y + rect1.height;

        double x3 = rect2.x;
        double y3 = rect2.y;
        double x4 = rect2.x + rect2.width;
        double y4 = rect2.y + rect2.height;

        double left = Math.max(x1, x3);
        double bottom = Math.max(y1, y3);
        double right = Math.min(x2, x4);
        double top = Math.min(y2, y4);

        if (left > right || bottom > top) {
            return null;
        } else {
            return new Rectangle(left, bottom, right - left, top - bottom);
        }
    }

    private Rectangle getRect(int[] grid) {
        int centerX = grid[0];
        int centerY = grid[1];
        int side = grid[2];
        double left = centerX - side / 2.0;
        double bottom = centerY - side / 2.0;
        return new Rectangle(left, bottom, side, side);
    }

    public int fieldOfGreatestBlessing(int[][] forceField) {
        int len = forceField.length;
        int ansMax = 1;
        Set<Integer>[] intersectionSetArr = new HashSet[len];
        Arrays.setAll(intersectionSetArr, value -> new HashSet<>());
        for (int i = 0; i < len; i++) {
            int[] grid = forceField[i];
            Rectangle rectangle1 = getRect(grid);
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                Rectangle rectangle2 = getRect(forceField[j]);
                Rectangle intersection = getIntersection(rectangle1, rectangle2);

                if (intersection != null) {
                    intersectionSetArr[i].add(j);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            Set<Integer> intersectionSet1 = intersectionSetArr[i];
            int count = 1;
            for (int interIdx1 : intersectionSet1) {
                Set<Integer> intersectionSet2 = intersectionSetArr[interIdx1];
                for (int interIdx2 : intersectionSet2) {
                    if (interIdx2 == i || intersectionSet1.contains(interIdx2)) {
                        count++;
                    }
                }
            }

        }

        return ansMax;
    }

}
