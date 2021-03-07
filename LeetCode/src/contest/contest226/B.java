package contest.contest226;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/31
 */
public class B {


    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int u = pair[0];
            int v = pair[1];
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);

            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }

        int firstNum = -1;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() == 1) {
                firstNum = key;
                break;
            }
        }

        int[] ansArr = new int[n];
        int i = 0;
        int curNum = firstNum;
        Set<Integer> set = new HashSet<>();
        while (i < n) {
            if (i == 0) {
                ansArr[i] = curNum;
                set.add(curNum);
                curNum = map.get(curNum).get(0);
                i++;
                continue;
            }

            if (i == n - 1) {
                ansArr[i] = curNum;
                i++;
                break;
            }

            ansArr[i] = curNum;
            set.add(curNum);
            List<Integer> adjList = map.get(curNum);
            if (set.contains(adjList.get(0))) {
                curNum = adjList.get(1);
            } else {
                curNum = adjList.get(0);
            }
            i++;
        }
        return ansArr;
    }

}
