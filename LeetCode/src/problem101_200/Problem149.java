package problem101_200;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Problem149 {

    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 20;

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        // 斜率->count
        Map<String, Integer> kCountMap = new HashMap<>();
        int maxSameKCount = 1;

        for (int i = 0; i < n; i++) {
            int samePointCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                    // 有重合点
                    samePointCount++;
                    continue;
                }

                int ydiff = points[i][1] - points[j][1];
                int xdiff = points[i][0] - points[j][0];

                String k = "0";
                if (xdiff == 0) {
                    k = "1";
                } else {
                    BigDecimal b1 = new BigDecimal(Double.toString(ydiff));
                    BigDecimal b2 = new BigDecimal(Double.toString(xdiff));
                    k = b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).toString();
                }

                if (kCountMap.containsKey(k)) {
                    kCountMap.put(k, kCountMap.get(k) + 1);
                } else {
                    kCountMap.put(k, 1);
                }
            }

            if (kCountMap.isEmpty()) {
                // 全部点都是重合点
                maxSameKCount = n - 1;
                break;
            }

            for (Integer count: kCountMap.values()) {
                if (count + samePointCount > maxSameKCount) {
                    maxSameKCount = count + samePointCount;
                }
            }

            kCountMap.clear();
        }

        return maxSameKCount + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem149().maxPoints(new int[][]{
                {1,1},
                {2,2},
                {3,3}
        }));

        System.out.println(new Problem149().maxPoints(new int[][]{
                {1,1},
                {3,2},
                {5,3},
                {4,1},
                {2,3},
                {1,4}
        }));

        System.out.println(new Problem149().maxPoints(new int[][]{
                {1,1},
                {1,1},
                {2,2},
                {2,2}
        }));

        System.out.println(new Problem149().maxPoints(new int[][]{
                {1,1},
                {1,1},
                {1,1},
        }));

        System.out.println(new Problem149().maxPoints(new int[][]{
                {0,0},
                {94911151,94911150},
                {94911152,94911151},
        }));
    }
    
}
