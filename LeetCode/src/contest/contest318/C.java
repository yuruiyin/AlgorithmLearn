package contest.contest318;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C {

    class Data {
        int idx;
        int cost;
        Data(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        long ans = 0;
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.cost == o2.cost ? o1.idx - o2.idx : o1.cost - o2.cost;
            }
        });
        if (candidates * 2 >= len) {
            for (int i = 0; i < len; i++) {
                heap.add(new Data(i, costs[i]));
            }
            while ((k--) > 0) {
                ans += heap.poll().cost;
            }
            return ans;
        }

        for (int i = 0; i < candidates; i++) {
            heap.add(new Data(i, costs[i]));
        }
        for (int i = len - candidates; i < len; i++) {
            heap.add(new Data(i, costs[i]));
        }

        int maxL = candidates - 1;
        int minR = len - candidates;
        while (maxL + 1 < minR && (k--) > 0) {
            Data top = heap.poll();
            ans += top.cost;
            if (top.idx <= maxL) {
                maxL++;
                heap.add(new Data(maxL, costs[maxL]));
            } else {
                minR--;
                heap.add(new Data(minR, costs[minR]));
            }
        }
        while ((k--) > 0) {
            ans += heap.poll().cost;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
    }

}
