package spring_2023_personal;

import java.util.*;

public class C_1 {

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
        // 扫描线
        Rectangle[] rectangles = new Rectangle[len];
        for (int i = 0; i < len; i++) {
            rectangles[i] = getRect(forceField[i]);
        }

        Arrays.sort(rectangles, new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                return Double.compare(o1.x, o2.x);
            }
        });

        for (int i = 0; i < len; i++) {
            double x = rectangles[i].x;
            // 计算有多个矩形在包含x
            List<Rectangle> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (rectangles[j].x <= x && rectangles[j].x + rectangles[j].width >= x) {
                    list.add(rectangles[j]);
                }
            }
            Collections.sort(list, new Comparator<Rectangle>() {
                @Override
                public int compare(Rectangle o1, Rectangle o2) {
                    return Double.compare(o1.y, o2.y);
                }
            });
            for (int j = 0; j < list.size(); j++) {
                double y = list.get(j).y;
                int count = 0;
                for (int k = 0; k < list.size(); k++) {
                    Rectangle rectangle = list.get(k);
                    if (rectangle.y <= y && rectangle.y + rectangle.height >= y) {
                        count++;
                    }
                }
                ansMax = Math.max(ansMax, count);
            }
        }

        return ansMax;
    }

}
