package contest.contest239;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/13
 */
public class D {

    class Data {
        int i;
        int num;
        Data(int i, int num) {
            this.i = i;
            this.num = num;
        }
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o1[0]) == (o2[1] - o2[0]) ? o1[0] - o2[0] : (o1[1] - o1[0]) - (o2[1] - o2[0]); // 长度从小到大排序
            }
        });

        for (int[] interval : intervals) {
            treeSet.add(interval);
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        Data[] datas = new Data[queries.length];
        for (int i = 0; i < queries.length; i++) {
            datas[i] = new Data(i, queries[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.num - o2.num;
            }
        });

        int[] ansArr = new int[queries.length];
        int from = 0;
        for (int i = 0; i < datas.length; i++) {
            Data data = datas[i];
            int idx = data.i;
            int target = data.num;
            for (int j = from; j < intervals.length; j++) {
                if (intervals[j][1] < target) {
                    treeSet.remove(intervals[j]);
                    from = j + 1;
                } else {
                    if (intervals[j][0] > target) {
                        ansArr[idx] = -1;
                    }
                    break;
                }
            }

            if (ansArr[idx] == -1) {
                continue;
            }

            if (intervals[from][0] <= target) {
                int[] least = treeSet.first();
                ansArr[idx] = least[1] - least[0] + 1;
            } else {
                ansArr[idx] = -1;
            }

        }
        return ansArr;
    }

    public static void main(String[] args) {
        int[] ansArr = new D().minInterval(new int[][]{
                {1,4},{2,4},{3,6},{4,4}
        }, new int[]{2,3,4,5});
    }

}
