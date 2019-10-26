package contest.contest148;

import java.util.ArrayList;
import java.util.List;

public class Problem1146 {

    class Data {
        int index;
        int val;
        Data(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    class Snap {
        List<Data> dataList;
        Snap(List<Data> dataList) {
            this.dataList = dataList;
        }
    }

    private int snapCount = 0;

    private int[] arr;

    private List<Snap> snaps;

    public Problem1146(int length) {
        arr = new int[length];
        snaps = new ArrayList<>();
    }

    public void set(int index, int val) {
        arr[index] = val;
    }

    public int snap() {
        snapCount++;

        List<Data> dataList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                dataList.add(new Data(i, arr[i]));
            }
        }

        Snap snap = new Snap(dataList);
        snaps.add(snap);

        return snapCount - 1;
    }

    public int get(int index, int snap_id) {
        List<Data> dataList = snaps.get(snap_id).dataList;

        for (Data data: dataList) {
            if (data.index == index) {
                return data.val;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
