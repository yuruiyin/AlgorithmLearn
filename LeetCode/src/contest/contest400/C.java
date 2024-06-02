package contest.contest400;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C {

    class Data {
        char c;
        int idx;

        Data(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
    }

    public String clearStars(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        int preMinIdx = -1;
        int startIdx = 0;
        char preMinChar = 'z';
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.c == o2.c ? o2.idx - o1.idx : o1.c - o2.c;
            }
        });
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (arr[i] == '*') {
                Data top = heap.poll();
                if (top != null) {
                    visited[top.idx] = true;
                }
            } else {
                heap.add(new Data(arr[i], i));
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] == '*' || visited[i]) {
                continue;
            }
            sb.append(arr[i]);
        }

        return sb.toString();
    }

}
