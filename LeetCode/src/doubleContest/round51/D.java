package doubleContest.round51;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/12
 */
public class D {

    class Data {
        int i;
        int[] query;
        Data(int i, int[] query) {
            this.i = i;
            this.query = query;
        }
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // 根据roomId排序
            }
        });

        treeSet.addAll(Arrays.asList(rooms));

        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1]; //根据size排序
            }
        });

        List<Data> queryDatas = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            queryDatas.add(new Data(i, queries[i]));
        }

        queryDatas.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.query[1] - o2.query[1];  // minSize从小到大排序
            }
        });

        int[] ansArr = new int[queries.length];
        int from = 0;
        for (Data queryData: queryDatas) {
            int[] query = queryData.query;
            int preferred = query[0];
            int minSize = query[1];
            for (int i = from; i < rooms.length; i++) {
                if (rooms[i][1] < minSize) {
                    from = i + 1;
                    treeSet.remove(rooms[i]);
                } else {
                    break;
                }
            }

            int[] ceiling = treeSet.ceiling(query);
            int[] floor = treeSet.floor(query);
            int idx = queryData.i;
            if (floor == null && ceiling == null) {
                ansArr[idx] = -1;
            } else if (floor == null) {
                ansArr[idx] = ceiling[0];
            } else if (ceiling == null) {
                ansArr[idx] = floor[0];
            } else {
                int ceilingId = ceiling[0];
                int floorId = floor[0];
                if (preferred - floorId <= ceilingId - preferred) {
                    ansArr[idx] = floorId;
                } else {
                    ansArr[idx] = ceilingId;
                }
            }
        }

        return ansArr;
    }

}
