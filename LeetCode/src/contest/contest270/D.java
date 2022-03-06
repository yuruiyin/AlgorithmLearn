package contest.contest270;

import java.util.*;

/**
 * a
 *
 * @author: yry
 * @date: 2021/12/5
 */
public class D {

    private List<Integer> ansIndexList;
    private int[][] pairs;

    private boolean isOk(int curIdx, Map<Integer, LinkedList<Integer>> map, List<Integer> tmpList) {
        if (tmpList.size() == pairs.length) {
            ansIndexList = tmpList;
            return true;
        }

        int[] pair = pairs[curIdx];
        int e = pair[1];
        LinkedList<Integer> nextIndexQueue = map.get(e);
        if (nextIndexQueue == null) {
            return false;
        }

        int size = nextIndexQueue.size();
        int i = 0;
        while (!nextIndexQueue.isEmpty() && i < size) {
            int nextIdx = nextIndexQueue.pollFirst();
            tmpList.add(nextIdx);
            boolean flag = isOk(nextIdx, map, tmpList);
            if (flag) {
                return true;
            }

            tmpList.remove(tmpList.size() - 1);
            nextIndexQueue.addLast(nextIdx);
            i++;
        }

        return false;
    }

    private int[][] convert(List<Integer> indexList) {
        int size = indexList.size();
        int[][] arr = new int[size][2];
        for (int i = 0; i < size; i++) {
            arr[i] = pairs[indexList.get(i)];
        }
        return arr;
    }

    public int[][] validArrangement(int[][] pairs) {
        this.pairs = pairs;
        int len = pairs.length;
        Map<Integer, LinkedList<Integer>> startMap = new HashMap<>();
        Map<Integer, Set<Integer>> endMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] pair = pairs[i];
            int s = pair[0];
            int e = pair[1];
            if (!startMap.containsKey(s)) {
                startMap.put(s, new LinkedList<>());
            }
            startMap.get(s).add(i);

            if (!endMap.containsKey(e)) {
                endMap.put(e, new HashSet<>());
            }
            endMap.get(e).add(i);
        }

        int from = 0;
        for (int i = 0; i < len; i++) {
            Set<Integer> endIndexSet = endMap.get(pairs[i][0]);
            if (endIndexSet == null || endIndexSet.iterator().next() == i) {
                from = i;
                break;
            }
        }

        int[] pair = pairs[from];
        startMap.get(pair[0]).remove((Integer) from);
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(from);
        if (isOk(from, startMap, tmpList)) {
            return convert(ansIndexList);
        }

        return null;
    }

}
