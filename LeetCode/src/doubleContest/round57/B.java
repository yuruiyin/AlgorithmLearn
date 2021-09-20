package doubleContest.round57;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/24
 */
public class B {

    class Data {
        int idx;
        int s;
        int e;
        Data(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int len = times.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(i, times[i][0], times[i][1]);
        }
        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.s - o2.s;
            }
        });

        int[] countArr = new int[len];
        Map<Integer, LinkedList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            Data data = datas[i];

            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Integer endTime = iterator.next();
                if (data.s < endTime) {
                    break;
                }

                LinkedList<Integer> idxList = map.get(endTime);
                if (idxList == null || idxList.isEmpty()) {
                    continue;
                }

                while (!idxList.isEmpty()) {
                    countArr[idxList.poll()]--;
                }
                iterator.remove();
            }

            int curIdx = -1;
            for (int j = 0; j < len; j++) {
                if (countArr[j] == 0) {
                    curIdx = j;
                    break;
                }
            }
            if (data.idx == targetFriend) {
                return curIdx;
            }

            if (!map.containsKey(data.e)) {
                map.put(data.e , new LinkedList<>());
            }
            map.get(data.e).addLast(curIdx);
            countArr[curIdx]++;
        }


        return -1;
    }

}
