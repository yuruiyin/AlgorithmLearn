package problem901_1000;

import java.util.Arrays;
import java.util.Comparator;

public class Problem939 {

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class CustomCmp implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }

            return o1.y - o2.y;
        }
    }

    public int minAreaRect(int[][] points) {
        int n = points.length;
        Point[] pointList = new Point[n];

        for (int i = 0; i < n; i++) {
            pointList[i] = new Point(points[i][0], points[i][1]);
        }

        Arrays.sort(pointList, new CustomCmp());

        int min = Integer.MAX_VALUE;

        // one two three four 代表四个点
        for (int one = 0; one < n - 3; one++) {
            for (int two = one + 1; two < n - 2; two++) {
                if (pointList[two].x != pointList[one].x) {
                    break;
                }

                int height = pointList[two].y - pointList[one].y;
                boolean hasFound = false;
                for (int three = two + 1; three < n - 1; three++) {
                    if ((pointList[three].x - pointList[one].x) * height > min) {
                        // 在高度由第一个点和第二个点固定的前提下，如果此时的宽*高构成的面积大于已有的min，则无需继续找第三个点了。
                        break;
                    }

                    // 这里可优化，在第一点和第二点确定的前提的，要找第三个点，通过预处理，可以直接跳到大于x的值开始
                    if (pointList[three].x == pointList[one].x || pointList[three].y != pointList[one].y) {
                        continue;
                    }

                    for (int four = three + 1; four < n; four++) {
                        if (pointList[four].x != pointList[three].x) {
                            break;
                        }

                        int curHeight = pointList[four].y - pointList[three].y;
                        if (curHeight > height) {
                            break;
                        }

                        if (curHeight == height) {
                            int area = height * (pointList[three].x - pointList[one].x);
                            if (area < min) {
                                min = area;
                            }
                            hasFound = true;
                            break;
                        }
                    }

                    if (hasFound) {
                        break;
                    }
                }
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem939().minAreaRect(new int[][]{
                {1,1},{1,3},{3,1},{3,3},{4,1},{4,3}
        })); //2

        System.out.println(new Problem939().minAreaRect(new int[][]{
                {3,2},{3,1},{4,4},{1,1},{4,3},{0,3},{0,2},{4,0}
        })); //0

        System.out.println(new Problem939().minAreaRect(new int[][]{
                {1,3},{2,1},{2,0},{4,3},{0,4},{4,2},{1,0},{3,4},{2,4},{4,0}
        })); //9

        System.out.println(new Problem939().minAreaRect(new int[][]{
                {16574,14889},{16647,25422},{8979,14889},{22226,16547},{22226,14889},{16647,24259},{19768,3426},{19768,25422},{8979,10409},{22226,24259},{17599,16547},{8979,8631},{22226,10409},{17599,1973},{16647,8631},{29472,8631},{29472,14889},{38102,16547},{16647,14889},{16574,1973},{16574,25422},{27869,14889},{27869,17193},{38102,10409},{19768,16547},{27869,3426},{19768,8631},{27869,24259},{29472,17193},{17599,24259},{16647,3426},{16647,10409},{38102,24259},{19768,3177},{38102,3426},{22226,23468},{17599,10409},{22240,16547},{22240,23468},{22240,3177},{27869,23468},{8979,16547},{22226,17193},{38102,8631},{29472,16547},{8979,17193},{19768,14889},{16647,16547},{29472,10409},{29472,1973},{16647,23468},{27869,3177},{22226,3426},{22226,25422},{16574,8631},{16574,3426},{17599,23468},{38102,14889},{8979,24259},{17599,3426},{29472,25422},{27869,25422},{22226,1973},{16647,17193},{29472,3426},{16647,3177}
        })); //96894
    }
    
}
