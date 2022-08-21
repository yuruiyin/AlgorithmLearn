package doubleContest.round085;

import utils.TreeMultiSet;

import java.util.*;

public class D {

    class Data {
        int l;
        int r;
        Data(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    private long getSum(long[] preSumArr, Data data) {
        return data.l == 0 ? preSumArr[data.r] : preSumArr[data.r] - preSumArr[data.l - 1];
    }

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        Data firstData = new Data(0, len - 1);
        TreeSet<Data> indexSortTreeSet = new TreeSet<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.l - o2.l;
            }
        });

        indexSortTreeSet.add(firstData);
        TreeMultiSet<Data> treeSet = new TreeMultiSet<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Long.compare(getSum(preSumArr, o1), getSum(preSumArr, o2));
            }
        });
        treeSet.add(firstData);

        long[] ansArr = new long[len];
        for (int i = 0; i < len; i++) {
            int removeIdx = removeQueries[i];
            Data data = indexSortTreeSet.floor(new Data(removeIdx, removeIdx));
            treeSet.remove(data);
            indexSortTreeSet.remove(data);
            int l = data.l;
            int r = data.r;
            if (l < r) {
                if (removeIdx == l) {
                    Data newData = new Data(l + 1, r);
                    treeSet.add(newData);
                    indexSortTreeSet.add(newData);
                } else if (removeIdx == r) {
                    Data newData = new Data(l, r - 1);
                    treeSet.add(newData);
                    indexSortTreeSet.add(newData);
                } else {
                    Data newData1 = new Data(l, removeIdx - 1);
                    treeSet.add(newData1);
                    indexSortTreeSet.add(newData1);
                    Data newData2 = new Data(removeIdx + 1, r);
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
        new D().maximumSegmentSum(new int[]{1,2,3,4,5}, new int[]{3,0,4,2,1});
    }

}
