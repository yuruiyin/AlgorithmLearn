package doubleContest.round137;

import java.util.*;

public class D {

    static class Data {
        long value;
        int i;
        int j;
        Data(long value, int i, int j) {
            this.value = value;
            this.i = i;
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
                arr[i].add(new Data(grid[i][j], i, j));
                if (arr[i].size() > 3) {
                    arr[i].poll();
                }
            }
        }

        List<Data> totalList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            while (!arr[i].isEmpty()) {
                totalList.add(arr[i].poll());
            }
        }
        Collections.sort(totalList, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Long.compare(o2.value, o1.value);
            }
        });

        long ans = (long) -4e9;
        int len = totalList.size();
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len - 2; i++) {
            Data data1 = totalList.get(i);
            long value1 = data1.value;
            int row1 = data1.i;
            int col1 = data1.j;
            for (int j = i + 1; j < len - 1; j++) {
                if (visited[j]) {
                    continue;
                }
                Data data2 = totalList.get(j);
                long value2 = data2.value;
                int row2 = data2.i;
                int col2 = data2.j;
                if (row2 == row1 || col1 == col2) {
                    continue;
                }

                for (int k = j + 1; k < len; k++) {
                    if (visited[k]) {
                        continue;
                    }
                    Data data3 = totalList.get(k);
                    long value3 = data3.value;
                    int row3 = data3.i;
                    int col3 = data3.j;
                    if (row3 == row2 || row3 == row1 || col3 == col1 || col3 == col2) {
                        continue;
                    }

                    visited[i] = true;
                    visited[j] = true;
                    visited[k] = true;
                    ans = Math.max(ans, value1 + value2 + value3);
                }
            }
        }

        return ans;
    }
    
}
