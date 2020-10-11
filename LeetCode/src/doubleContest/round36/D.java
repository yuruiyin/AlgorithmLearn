package doubleContest.round36;

import utils.PrintUtil;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/3
 */
public class D {

    class Data {
        int index;
        int endTime;

        Data(int index, int endTime) {
            this.index = index;
            this.endTime = endTime;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int len = arrival.length;
        PriorityQueue<Data> heap = new PriorityQueue<>(k, Comparator.comparingInt(o -> o.endTime));

        int[] countArr = new int[k];
        TreeSet<Integer> emptySet = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            emptySet.add(i);
        }

        for (int i = 0; i < len; i++) {
            while (!heap.isEmpty() && heap.peek().endTime <= arrival[i]) {
                emptySet.add(heap.poll().index);
            }

            if (emptySet.isEmpty()) {
                continue;
            }

            int endTime = arrival[i] + load[i];
            Integer targetIndex = emptySet.ceiling(i % k);
            if (targetIndex == null) {
                targetIndex = emptySet.first();
            }

            countArr[targetIndex]++;
            heap.offer(new Data(targetIndex, endTime));
            emptySet.remove(targetIndex);
        }

        int maxCount = 0;
        for (int i = 0; i < k; i++) {
            maxCount = Math.max(maxCount, countArr[i]);
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (countArr[i] == maxCount) {
                ansList.add(i);
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<Integer> ansList = new D().busiestServers(3, new int[]{1, 2, 3, 4}, new int[]{1, 2, 1, 2});
        PrintUtil.printIntList(ansList);
    }

}
