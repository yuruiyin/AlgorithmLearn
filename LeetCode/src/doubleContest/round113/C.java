package doubleContest.round113;

import java.util.*;

public class C {

    public int countPairs(List<List<Integer>> coordinates, int k) {
        long N = (long) (1e6 + 1);
        int size = coordinates.size();
        int ans = 0;
        for (int l = 0; l <= k; l++) {
            int r = k - l;
            Map<Long, Integer> countMap = new HashMap<>();
            List<Integer> firstNode = coordinates.get(0);
            long key = firstNode.get(0) * N + firstNode.get(1);
            countMap.put(key, 1);
            for (int i = 1; i < size; i++) {
                List<Integer> curNode = coordinates.get(i);
                int x = curNode.get(0);
                int y = curNode.get(1);
                long expectX = x ^ l;
                long expectY = y ^ r;
                ans += countMap.getOrDefault(expectX * N + expectY, 0);
                long tmpKey = x * N + y;
                countMap.put(tmpKey, countMap.getOrDefault(tmpKey, 0) + 1);
            }
        }
        return ans;
    }

}
