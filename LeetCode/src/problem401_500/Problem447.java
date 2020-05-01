package problem401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem447
 *
 * @author: yry
 * @date: 2020/4/15
 */
public class Problem447 {

    private int dis(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> disToCountMap = new HashMap<>();
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = dis(x1, y1, x2, y2);
                disToCountMap.put(dis, disToCountMap.getOrDefault(dis, 0) + 1);
            }

            for (Integer dis : disToCountMap.keySet()) {
                int count = disToCountMap.get(dis);
                ans += count * (count - 1);
            }
        }

        return ans;
    }

}
