package contest.contest259;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/19
 */
public class C {

    class DetectSquares {

        private int[][] countArr;

        public DetectSquares() {
            countArr = new int[1001][1001];
        }

        public void add(int[] point) {
            int x = point[0];
            int y = point[1];
            countArr[x][y]++;
        }

        public int count(int[] point) {
            int x = point[0];
            int y = point[1];
            int ans = 0;
            for (int l = 1; l <= 1000; l++) {
                int x1 = x + l;
                int y1 = y;
                int x2 = x + l;
                int y2 = y + l;
                int x3 = x;
                int y3 = y + l;
                ans += countArr[x1 + 1000][y1 + 1000] * countArr[x2 + 1000][y2 + 1000] * countArr[x3 + 1000][y3 + 1000];

                x1 = x + l;
                y1 = y;
                x2 = x + l;
                y2 = y - l;
                x3 = x;
                y3 = y - l;
                ans += countArr[x1 + 1000][y1 + 1000] * countArr[x2 + 1000][y2 + 1000] * countArr[x3 + 1000][y3 + 1000];

                x1 = x - l;
                y1 = y;
                x2 = x - l;
                y2 = y - l;
                x3 = x;
                y3 = y - l;
                ans += countArr[x1 + 1000][y1 + 1000] * countArr[x2 + 1000][y2 + 1000] * countArr[x3 + 1000][y3 + 1000];

                x1 = x - l;
                y1 = y;
                x2 = x - l;
                y2 = y + l;
                x3 = x;
                y3 = y + l;
                ans += countArr[x1 + 1000][y1 + 1000] * countArr[x2 + 1000][y2 + 1000] * countArr[x3 + 1000][y3 + 1000];
            }
            return ans;
        }
    }

}
