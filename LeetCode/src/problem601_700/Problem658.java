package problem601_700;

import java.util.*;

public class Problem658 {

    class Data {
        int idx;
        int abs;
        Data(int idx, int abs) {
            this.idx = idx;
            this.abs = abs;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ansList = new ArrayList<>();
        PriorityQueue<Data> heap = new PriorityQueue<>(k, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.abs == o2.abs ? o1.idx - o2.idx : o2.abs - o1.abs;
            }
        });

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            heap.add(new Data(i, Math.abs(arr[i] - x)));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        for (Data data : heap) {
            ansList.add(arr[data.idx]);
        }

        Collections.sort(ansList);
        return ansList;
    }

}
