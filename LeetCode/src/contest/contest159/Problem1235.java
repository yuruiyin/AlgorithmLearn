package contest.contest159;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1235 {

    private int ansMax = 0;
    private int[] memo;         //某个start开始的最大值
    private int[] memoAfterMax; // 某个start开始后面各种路径的最大值。
    private int[] memoNextStartIndex; // end对应的next合法的start在start数组中的位置。

    class Data {
        int start;
        int end;
        int profit;

        Data(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    class CustomCmp implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            return o1.start - o2.start;
        }
    }

    private int find(Data[] datas, int low, int targetIndex) {
        if (memoNextStartIndex[targetIndex] != -2) {
            return memoNextStartIndex[targetIndex];
        }

        int target = datas[targetIndex].end;
        int high = datas.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int midStart = datas[mid].start;
            if (midStart >= target) {
                if (mid == 0 || datas[mid-1].start < target) {
                    memoNextStartIndex[targetIndex] = mid;
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        memoNextStartIndex[targetIndex] = -1;
        return -1;
    }

    private int backTrace(Data[] datas, int from) {
        if (memo[from] != 0) {
            return memo[from];
        }

        if (from == datas.length - 1) {
            memo[from] = datas[from].profit;
            return memo[from];
        }

        Data data = datas[from];
        int profit = data.profit;
        int nextStartIndex = find(datas, from + 1, from);

        if (nextStartIndex == -1) {
            memo[from] = profit;
            return profit;
        }

        int subMax = 0;
        if (memoAfterMax[nextStartIndex] != 0) {
            subMax = memoAfterMax[nextStartIndex];
        } else {
            for (int i = nextStartIndex; i < datas.length; i++) {
                if (memoAfterMax[i] != 0) { // 这个判断很重要，否则会超时，也就是后面从当前位置开始后面的最大已经计算过了，就可以直接跳出循环
                    if (memoAfterMax[i] > subMax) {
                        subMax = memoAfterMax[i];
                    }
                    break;
                }

                int subRes = backTrace(datas, i);
                if (subRes > subMax) {
                    subMax = subRes;
                }
            }
            memoAfterMax[nextStartIndex] = subMax;
        }

        memo[from] = profit + subMax;
        return memo[from];
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Data[] datas = new Data[n];

        for (int i = 0; i < n; i++) {
            datas[i] = new Data(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(datas, new CustomCmp());

        memo = new int[n];
        memoNextStartIndex = new int[n];
        memoAfterMax = new int[n];
        for (int i = 0; i < n; i++) {
            memoNextStartIndex[i] = -2;
        }
        for (int i = 0; i < n; i++) {
            if (memo[i] != 0) {
                continue;
            }
            int tmpAns = backTrace(datas, i);

            if (tmpAns > ansMax) {
                ansMax = tmpAns;
            }
        }

        return ansMax;

    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1235().jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
        System.out.println(new Problem1235().jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));
        System.out.println(new Problem1235().jobScheduling(new int[]{1,1,1}, new int[]{2,3,4}, new int[]{5,6,4}));
        System.out.println(new Problem1235().jobScheduling(new int[]{4,2,4,8,2}, new int[]{5,5,5,10,8}, new int[]{1,2,8,10,4}));
    }
    
}
