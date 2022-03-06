package contest.contest269;

import java.util.*;

/**
* a
*
* @author: yry
* @date: 2021/11/28
*/
public class D {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int time = meeting[2];
            if (!map.containsKey(time)) {
                map.put(time, new ArrayList<>());
            }
            map.get(time).add(new int[]{x, y});
        }

        for (int time: map.keySet()) {
            List<int[]> list = map.get(time);
            Set<Integer>[] tmpMap = new HashSet[n];
            Set<Integer> okSet = new HashSet<>();
            for (int[] edge : list) {
                int u = edge[0];
                int v = edge[1];
                if (set.contains(u)) {
                    okSet.add(u);
                }

                if (set.contains(v)) {
                    okSet.add(v);
                }
                if (tmpMap[u] != null && tmpMap[v] != null) {
                    Set<Integer> mergeSet = new HashSet<>();
                    mergeSet.addAll(tmpMap[u]);
                    mergeSet.addAll(tmpMap[v]);
                    for (int tmpNode : tmpMap[u]) {
                        tmpMap[tmpNode] = mergeSet;
                    }
                    for (int tmpNode : tmpMap[v]) {
                        tmpMap[tmpNode] = mergeSet;
                    }
                    tmpMap[u] = mergeSet;
                    tmpMap[v] = mergeSet;
                } else if (tmpMap[u] != null && tmpMap[v] == null) {
                    tmpMap[u].add(v);
                    tmpMap[v] = tmpMap[u];
                } else if (tmpMap[u] == null && tmpMap[v] != null) {
                    tmpMap[v].add(u);
                    tmpMap[u] = tmpMap[v];
                } else {
                    // !tmpMap.containsKey(u) && !tmpMap.containsKey(v)
                    Set<Integer> tmpSet = new HashSet<>();
                    tmpSet.add(u);
                    tmpSet.add(v);
                    tmpMap[u] = tmpSet;
                    tmpMap[v] = tmpSet;
                }
            }

            Set<Set<Integer>> visited = new HashSet<>();
            for (int node : okSet) {
                Set<Integer> tmpSet = tmpMap[node];
                if (visited.contains(tmpSet)) {
                    continue;
                }

                visited.add(tmpSet);
                set.addAll(tmpSet);
            }
        }

        List<Integer> ansList = new ArrayList<>(set);
        Collections.sort(ansList);
        return ansList;
    }

    public static void main(String[] args) {
//        5
//                [[1,3,3],[2,0,3],[2,3,3]]
//        4

        new D().findAllPeople(5, new int[][]{
                {1,3,3},{2,0,3},{2,3,3}
        }, 4);
    }

}
