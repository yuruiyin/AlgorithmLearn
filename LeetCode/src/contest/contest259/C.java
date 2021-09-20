package contest.contest259;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/19
 */
public class C {

    class DetectSquares {

        private Map<Integer, Integer> countMap;

        public DetectSquares() {
            countMap = new HashMap<>();
        }

        public void add(int[] point) {
            int x = point[0];
            int y = point[1];
            int key = x * 1001 + y;
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
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
                ans += countMap.getOrDefault(x1 * 1001 + y1, 0) *
                        countMap.getOrDefault(x2 * 1001 + y2, 0) *
                        countMap.getOrDefault(x3 * 1001 + y3, 0);

                x1 = x + l;
                y1 = y;
                x2 = x + l;
                y2 = y - l;
                x3 = x;
                y3 = y - l;
                ans += countMap.getOrDefault(x1 * 1001 + y1, 0) *
                        countMap.getOrDefault(x2 * 1001 + y2, 0) *
                        countMap.getOrDefault(x3 * 1001 + y3, 0);

                x1 = x - l;
                y1 = y;
                x2 = x - l;
                y2 = y - l;
                x3 = x;
                y3 = y - l;
                ans += countMap.getOrDefault(x1 * 1001 + y1, 0) *
                        countMap.getOrDefault(x2 * 1001 + y2, 0) *
                        countMap.getOrDefault(x3 * 1001 + y3, 0);

                x1 = x - l;
                y1 = y;
                x2 = x - l;
                y2 = y + l;
                x3 = x;
                y3 = y + l;
                ans += countMap.getOrDefault(x1 * 1001 + y1, 0) *
                        countMap.getOrDefault(x2 * 1001 + y2, 0) *
                        countMap.getOrDefault(x3 * 1001 + y3, 0);
            }
            return ans;
        }
    }

}
