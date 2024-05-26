package doubleContest.round126;

import java.util.*;

public class B {

    class Data {
        int num;
        int idx;
        Data(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int len = nums.length;
        List<Data> dataList = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < len; i++) {
            dataList.add(new Data(nums[i], i));
            sum += nums[i];
        }

        Collections.sort(dataList, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.num == o2.num ? o1.idx - o2.idx : o1.num - o2.num;
            }
        });

        int qLen = queries.length;
        long[] ansArr = new long[qLen];
        int from = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < qLen; i++) {
            int idx = queries[i][0];
            int k = queries[i][1];
            if (!visited[idx]) {
                visited[idx] = true;
                sum -= nums[idx];
            }
            int count = 0;
            int j;
            for (j = from; count < k && j < len; j++) {
                Data data = dataList.get(j);
                if (visited[data.idx]) {
                    continue;
                }
                visited[data.idx] = true;
                count++;
                sum -= nums[data.idx];
            }
            from = j;
            ansArr[i] = sum;
        }
        return ansArr;
    }

}
