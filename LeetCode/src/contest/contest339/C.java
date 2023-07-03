package contest.contest339;

import java.util.*;

public class C {

    class Data {
        int idx;
        int num1;
        int num2;
        Data(int idx, int num1, int num2) {
            this.idx = idx;
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        if (k == 0) {
            int ans = 0;
            for (int num : reward2) {
                ans += num;
            }
            return ans;
        }
        int n = reward1.length;
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.num1 - o1.num2 - (o2.num1 - o2.num2);
            }
        });

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            heap.add(new Data(i, reward1[i], reward2[i]));
            ans += reward1[i];
            visited[i] = true;
            if (heap.size() > k) {
                Data data = heap.poll();
                visited[data.idx] = false;
                ans -= data.num1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            ans += reward2[i];
        }
        return ans;
    }

}
