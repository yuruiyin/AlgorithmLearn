package doubleContest.round126;

import java.util.*;

public class C {

    class Data {
        int count;
        int idx;
        Data(int count, int idx) {
            this.count = count;
            this.idx = idx;
        }
    }

    public String minimizeStringValue(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] countArr = new int[26];
        int needCount = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] != '?') {
                countArr[arr[i] - 'a']++;
            } else {
                needCount++;
            }
        }

        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.count == o2.count ? o1.idx - o2.idx : o1.count - o2.count;
            }
        });

        for (int i = 0; i < 26; i++) {
            heap.add(new Data(countArr[i], i));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (arr[i] == '?') {
                Data top = heap.poll();
                list.add(top.idx);
                heap.add(new Data(top.count + 1, top.idx));
            }
        }

        Collections.sort(list);
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (arr[i] == '?') {
                sb.append((char) (list.get(idx++) + 'a'));
            } else {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

}
