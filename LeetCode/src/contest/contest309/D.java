package contest.contest309;

import java.util.*;

public class D {

//    1 <= n <= 100
//    1 <= meetings.length <= 105
//    meetings[i].length == 2
//    0 <= starti < endi <= 5 * 105
//    starti 的所有值 互不相同

    class Data {
        int idx;
        long endTime;
        Data(int idx, long endTime) {
            this.idx = idx;
            this.endTime = endTime;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] ansCountArr = new int[n];
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.endTime == o2.endTime ? o1.idx - o2.idx : Long.compare(o1.endTime, o2.endTime);
            }
        });

        for (int i = 0; i < n; i++) {
            Data data = new Data(i, 0);
            heap.add(data);
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        long delayTime = 0;
        for (int[] m : meetings) {
            int startTime = m[0];
            int endTime = m[1];
            List<Data> dataList = new ArrayList<>();
            Iterator<Data> iterator = heap.iterator();
            while (iterator.hasNext()) {
                Data data = iterator.next();
                if (data.endTime != 0 && data.endTime <= startTime) {
                    iterator.remove();
                    data.endTime = 0;
                    dataList.add(data);
                }
            }

            for (Data data : dataList) {
                heap.add(data);
            }

            Data topData = heap.poll();
            if (topData.endTime == 0) {
                // 有空闲会议室
                delayTime = 0;
                topData.endTime = endTime + delayTime;
                heap.add(topData);
                ansCountArr[topData.idx]++;
            } else {
                // 没有空闲会议室
                delayTime = Math.max(0, topData.endTime - startTime);
                topData.endTime = endTime + delayTime;
                heap.add(topData);
                ansCountArr[topData.idx]++;
            }
        }

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            maxCount = Math.max(maxCount, ansCountArr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (ansCountArr[i] == maxCount) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        //4
        //[[19,20],[14,15],[13,14],[11,20]]
        System.out.println(new D().mostBooked(4, new int[][]{
                {19,20},{14,15},{13,14},{11,20}
        }));
    }

}
