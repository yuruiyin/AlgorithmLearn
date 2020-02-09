package contest.contest116;

import java.util.Arrays;
import java.util.Comparator;

public class Problem962_1 {

    class Data {
        int value;
        int index;
        Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int maxWidthRamp(int[] arr) {
        int len = arr.length;
        Data[] datas = new Data[len];

        for (int i = 0; i < len; i++) {
            datas[i] = new Data(arr[i], i);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.value - o2.value;
            }
        });

        int minIndex = datas[0].index;
        int maxDis = 0;
        for (int i = 1; i < len; i++) {
            maxDis = Math.max(maxDis, datas[i].index - minIndex);
            minIndex = Math.min(minIndex, datas[i].index);
        }

        return maxDis;
    }

}
