package doubleContest.round085;

import utils.TreeMultiSet;

import java.util.Comparator;
import java.util.TreeSet;

public class D_1 {

    private long getSum(long[] preSumArr, int[] data) {
        return data[0] == 0 ? preSumArr[data[1]] : preSumArr[data[1]] - preSumArr[data[0] - 1];
    }

    /**
     * 使用数组替代Data对象
     */
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        int[] firstData = new int[]{0, len - 1};
        TreeSet<int[]> indexSortTreeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        indexSortTreeSet.add(firstData);
        TreeMultiSet<int[]> treeSet = new TreeMultiSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Long.compare(getSum(preSumArr, o1), getSum(preSumArr, o2));
            }
        });
        treeSet.add(firstData);

        long[] ansArr = new long[len];
        for (int i = 0; i < len; i++) {
            int removeIdx = removeQueries[i];
            int[] data = indexSortTreeSet.floor(new int[]{removeIdx, removeIdx});
            treeSet.remove(data);
            indexSortTreeSet.remove(data);
            int l = data[0];
            int r = data[1];
            if (l < r) {
                if (removeIdx == l) {
                    int[] newData = new int[]{l + 1, r};
                    treeSet.add(newData);
                    indexSortTreeSet.add(newData);
                } else if (removeIdx == r) {
                    int[] newData = new int[]{l, r - 1};
                    treeSet.add(newData);
                    indexSortTreeSet.add(newData);
                } else {
                    int[] newData1 = new int[]{l, removeIdx - 1};
                    treeSet.add(newData1);
                    indexSortTreeSet.add(newData1);
                    int[] newData2 = new int[]{removeIdx + 1, r};
                    treeSet.add(newData2);
                    indexSortTreeSet.add(newData2);
                }
            }

            ansArr[i] = treeSet.isEmpty() ? 0 : getSum(preSumArr, treeSet.last());
        }
        return ansArr;
    }

    public static void main(String[] args) {
//        new D().maximumSegmentSum(new int[]{1,2,5,6,1}, new int[]{0,3,2,4,1});
//        [1,2,3,4,5]
//        [3,0,4,2,1]
        new D_1().maximumSegmentSum(new int[]{1,2,3,4,5}, new int[]{3,0,4,2,1});
    }

}
