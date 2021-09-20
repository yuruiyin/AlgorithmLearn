package contest.contest237;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/18
 */
public class C {

    class Data {
        int i;
        int start;
        int l;
        Data(int i, int start, int l) {
            this.i = i;
            this.start = start;
            this.l = l;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;

        Data[] datas = new Data[len];

        for (int i = 0; i < len; i++) {
            int[] task = tasks[i];
            int start = task[0];
            int l = task[1];
            datas[i] = new Data(i, start, l);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.start == o2.start ? (o1.l == o2.l ? o1.i - o2.i : o1.l - o2.l) : o1.start - o2.start;
            }
        });

        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.l == o2.l ? o1.i - o2.i : o1.l - o2.l;
            }
        });

        int[] ansArr = new int[len];

        int minStart = datas[0].start;
        int minL = datas[0].l;
        Data minData = datas[0];
        ansArr[0] = minData.i;
        int preEnd = minStart + minL;
        int index = 1;
        for (int i = 1; i < len; i++) {
            Data data = datas[i];
            if (data.start <= preEnd) {
                heap.add(data);
            } else {
                if (heap.isEmpty()) {
                    heap.add(data);
                } else {
                    Data tmpData = heap.poll();
                    ansArr[index++] = tmpData.i;
                    preEnd = tmpData.start + tmpData.l;
                    heap.add(data);
                }
            }
        }

        while (!heap.isEmpty()) {
            ansArr[index++] = heap.poll().i;
        }

        return ansArr;
    }

}
