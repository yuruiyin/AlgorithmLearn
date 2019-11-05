package problem101_200;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem149_1 {

    public int maxPoints(int[][] points) {
        int len = points.length;

        if (len == 0 || len == 1) {
            return len;
        }

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        Map<String, Integer> countMap = new HashMap<>();
        int count = 1;
        String key = null;
        String lastKey;
        for (int i = 1; i < len; i++) {
            key = points[i][0] + "," + points[i][1];
            lastKey = points[i-1][0] + "," + points[i-1][1];
            if (key.equals(lastKey)) {
                count++;
            } else {
                countMap.put(lastKey, count);
                count = 1;
            }
        }

        countMap.put(key, count);

        int max = Collections.max(countMap.values());
        for (int i = 0; i < len; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            if (i > 0 && x1 == points[i-1][0] && y1 == points[i-1][1]) {
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x2 == points[j-1][0] && y2 == points[j-1][1]) {
                    continue;
                }

                if (x2 == x1 && y2 == y1) {
                    continue;
                }

                int tmpCount = countMap.get(x1 + "," + y1) + countMap.get(x2 + "," + y2);

                for (int k = j + 1; k < len; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    if (x3 == x2 && y3 == y2 || x3 == x1 && y3 == y1) {
                        continue;
                    }

                    if ((long) (y2 - y1) * (x3 - x2) == (long) (y3 - y2) * (x2 - x1)) {
                        tmpCount++;
                    }
                }

                if (tmpCount > max) {
                    max = tmpCount;
                }
            }

        }

        return max;
    }
    
    public static void main(String[] args) {
        
    }
    
}
