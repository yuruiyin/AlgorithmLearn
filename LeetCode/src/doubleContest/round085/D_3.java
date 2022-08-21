package doubleContest.round085;

import utils.TreeMultiSet;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class D_3 {

    class Data {
        int l;
        int r;
        long sum;
        Data(int l, int r, long sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }

    private long getSum(long[] preSumArr, int l, int r) {
        return l == 0 ? preSumArr[r] : preSumArr[r] - preSumArr[l - 1];
    }

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        Data firstData = new Data(0, len - 1, getSum(preSumArr, 0, len - 1));
        TreeSet<Data> indexSortTreeSet = new TreeSet<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.l - o2.l;
            }
        });
        indexSortTreeSet.add(firstData);

        TreeMap<Long, Integer> countTreeMap = new TreeMap<>();
        countTreeMap.put(firstData.sum, 1);

        long[] ansArr = new long[len];
        for (int i = 0; i < len; i++) {
            int removeIdx = removeQueries[i];
            Data data = indexSortTreeSet.floor(new Data(removeIdx, removeIdx, 0));
            countTreeMap.put(data.sum, countTreeMap.get(data.sum) - 1);
            if (countTreeMap.get(data.sum) == 0) {
                countTreeMap.remove(data.sum);
            }
            indexSortTreeSet.remove(data);
            int l = data.l;
            int r = data.r;
            if (l < r) {
                if (removeIdx == l) {
                    long sum = getSum(preSumArr, l + 1, r);
                    Data newData = new Data(l + 1, r, sum);
                    indexSortTreeSet.add(newData);
                    countTreeMap.put(sum, countTreeMap.getOrDefault(sum, 0) + 1);
                } else if (removeIdx == r) {
                    long sum = getSum(preSumArr, l, r - 1);
                    Data newData = new Data(l, r - 1, sum);
                    indexSortTreeSet.add(newData);
                    countTreeMap.put(sum, countTreeMap.getOrDefault(sum, 0) + 1);
                } else {
                    long sum1 = getSum(preSumArr, l, removeIdx - 1);
                    Data newData1 = new Data(l, removeIdx - 1, sum1);
                    indexSortTreeSet.add(newData1);
                    countTreeMap.put(sum1, countTreeMap.getOrDefault(sum1, 0) + 1);
                    long sum2 = getSum(preSumArr, removeIdx + 1, r);
                    Data newData2 = new Data(removeIdx + 1, r, sum2);
                    indexSortTreeSet.add(newData2);
                    countTreeMap.put(sum2, countTreeMap.getOrDefault(sum2, 0) + 1);
                }
            }

            ansArr[i] = countTreeMap.isEmpty() ? 0 : countTreeMap.lastKey();
        }
        return ansArr;
    }

    public static void main(String[] args) {
//        new D().maximumSegmentSum(new int[]{1,2,5,6,1}, new int[]{0,3,2,4,1});
//        [1,2,3,4,5]
//        [3,0,4,2,1]
        new D_3().maximumSegmentSum(new int[]{1,2,3,4,5}, new int[]{3,0,4,2,1});
    }

}
