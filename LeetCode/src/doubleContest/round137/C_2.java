package doubleContest.round137;

import java.util.*;

public class C_2 {

    class Data {
        long value;
        int j;
        Data(long value, int j) {
            this.value = value;
            this.j = j;
        }
    }

    public long maximumValueSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<Data>[] arr = new PriorityQueue[m];
        for (int i = 0; i < m; i++) {
            arr[i] = new PriorityQueue<>(new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return Long.compare(o1.value, o2.value);
                }
            });
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i].add(new Data(grid[i][j], j));
                if (arr[i].size() > 3) {
                    arr[i].poll();
                }
            }
        }

        List<Data>[] listArr = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            List<Data> list = new ArrayList<>();
            while (!arr[i].isEmpty()) {
                list.add(arr[i].poll());
            }
            listArr[i] = list;
        }

        long ansMax = (long) -4e9;
        for (int i1 = 0; i1 < m; i1++) {
            List<Data> list1 = listArr[i1];
            for (int i2 = i1 + 1; i2 < m; i2++) {
                List<Data> list2 = listArr[i2];
                for (int i3 = i2 + 1; i3 < m; i3++) {
                    List<Data> list3 = listArr[i3];
                    for (Data data1 : list1) {
                        for (Data data2 : list2) {
                            if (data2.j == data1.j) {
                                continue;
                            }
                            for (Data data3: list3) {
                                if (data3.j == data1.j || data3.j == data2.j) {
                                    continue;
                                }

                                ansMax = Math.max(ansMax, data1.value + data2.value + data3.value);
                            }
                        }
                    }
                }
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {

    }

}
