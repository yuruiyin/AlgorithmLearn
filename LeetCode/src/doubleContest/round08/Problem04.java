package doubleContest.round08;

import sun.tools.jstat.Literal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem04 {

    class Point {
        int x;
        int y;
        int beUseCount;
        Point(int x, int y, int beUseCount) {
            this.x = x;
            this.y = y;
            this.beUseCount = beUseCount;
        }
    }

    class CustomCmp implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            return o1.beUseCount - o2.beUseCount;
        }
    }

    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] pointBeUseCount = new int[height][width];

        for (int i = 0; i < height; i++) {
            if (i + sideLength > height) {
                break;
            }
            for (int j = 0; j < width; j++) {
                if (j + sideLength > width) {
                    break;
                }

                for (int k = i; k < i + sideLength; k++) {
                    for (int l = j; l < j + sideLength; l++) {
                        pointBeUseCount[k][l]++;
                    }
                }
            }
        }

        int[][] matrix = new int[height][width];
        boolean[][] visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            if (i + sideLength > height) {
                break;
            }
            for (int j = 0; j < width; j++) {
                if (j + sideLength > width) {
                    break;
                }

                // 按点被正方形使用的次数从小到大排序
                List<Point> pointList = new ArrayList<>();
                int oneCount = 0;
                for (int k = i; k < i + sideLength; k++) {
                    for (int l = j; l < j + sideLength; l++) {
                        if (matrix[k][l] == 1) {
                            oneCount++;
                        }
                        if (visited[k][l]) {
                            continue;
                        }
                        pointList.add(new Point(k, l, pointBeUseCount[k][l]));
                        visited[k][l] = true;
                    }
                }
                pointList.sort(new CustomCmp());

                int leftOneCount = maxOnes - oneCount;
                // 将最少被使用的点置1
                for (int k = 0; leftOneCount > 0;k++) {
                    Point point = pointList.get(k);
                    if (matrix[point.x][point.y] == 1) {
                        continue;
                    }
                    matrix[point.x][point.y] = 1;
                    leftOneCount--;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    ans++;
                }
            }
        }

        return  ans;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem04().maximumNumberOfOnes(3,3,2,1));
//        System.out.println(new Problem04().maximumNumberOfOnes(3,3,2,2));
        System.out.println(new Problem04().maximumNumberOfOnes(10,10,4,5)); //42
//        System.out.println(new Problem04().maximumNumberOfOnes(4,4,2,2)); //42
    }
}

//        示例 1：
//
//        输入：width = 3, height = 3, sideLength = 2, maxOnes = 1
//        输出：4
//        解释：
//        题目要求：在一个 3*3 的矩阵中，每一个 2*2 的子阵中的 1 的数目不超过 1 个。
//        最好的解决方案中，矩阵 M 里最多可以有 4 个 1，如下所示：
//        [1,0,1]
//        [0,0,0]
//        [1,0,1]

//        示例 2：
//
//        输入：width = 3, height = 3, sideLength = 2, maxOnes = 2
//        输出：6
//        解释：
//        [1,0,1]
//        [1,0,1]
//        [1,0,1]
//
//
//        提示：
//
//        1 <= width, height <= 100
//        1 <= sideLength <= width, height
//        0 <= maxOnes <= sideLength * sideLength
