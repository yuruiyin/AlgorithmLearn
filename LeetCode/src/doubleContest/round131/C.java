package doubleContest.round131;

import java.util.*;

public class C {

    public int[] queryResults(int limit, int[][] queries) {
        int len = queries.length;
        int[] ansArr = new int[len];
        Map<Integer, Set<Integer>> listMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] q = queries[i];
            int x = q[0];
            int y = q[1];
            if (map.containsKey(x)) {
                int color = map.get(x);
                Set<Integer> tmpSet = listMap.get(color);
                tmpSet.remove(x);
                if (tmpSet.isEmpty()) {
                    listMap.remove(color);
                }
            }

            if (!listMap.containsKey(y)) {
                listMap.put(y, new HashSet<>());
            }

            Set<Integer> set = listMap.get(y);
            set.add(x);
            map.put(x, y);
            ansArr[i] = listMap.size();
        }
        return ansArr;
    }

}
