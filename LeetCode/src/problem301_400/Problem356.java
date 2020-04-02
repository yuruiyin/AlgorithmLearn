package problem301_400;

import java.util.*;

/**
 * Problem356
 *
 * @author: yry
 * @date: 2020/4/1
 */
public class Problem356 {

    private boolean isOk(List<Integer> xList, double midX) {
        int size = xList.size();
        int mid = size / 2;
        for (int i = 0; i <= mid; i++) {
            if ((xList.get(i) + xList.get(size - 1 - i)) / 2.0 != midX) {
                return false;
            }
        }
        return true;
    }

    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) {
            return true;
        }

        // 统计每个y的点list
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!map.containsKey(y)) {
                map.put(y, new TreeSet<>());
            }
            map.get(y).add(x);
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        int y1 = iterator.next();
        List<Integer> xList1 = new ArrayList<>(map.get(y1));
        double midX = (xList1.get(0) + xList1.get(xList1.size() - 1)) / 2.0;
        if (!isOk(xList1, midX)) {
            return false;
        }

        while (iterator.hasNext()) {
            int y = iterator.next();
            List<Integer> xList = new ArrayList<>(map.get(y));
            if (!isOk(xList, midX)) {
                return false;
            }
        }

        return true;
    }

}
