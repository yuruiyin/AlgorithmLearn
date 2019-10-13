package problem1_100;

import java.util.Arrays;
import java.util.Comparator;

public class Problem056 {

    class IntervalData {
        int left;
        int right;

        public IntervalData(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    class CustomCmp implements Comparator<IntervalData> {

        @Override
        public int compare(IntervalData o1, IntervalData o2) {
            if (o1.left != o2.left) {
                return o1.left - o2.left;
            } else {
                return o1.right - o2.right;
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if (n == 0) {
            return new int[0][0];
        }

        IntervalData[] arr = new IntervalData[n];
        int num = 0;

        for (int[] interval : intervals) {
            arr[num++] = new IntervalData(interval[0], interval[1]);
        }

        Arrays.sort(arr, 0, num, new CustomCmp());

        int[][] tmpIntervals = new int[num][2];

        int count = 0;
        for (int i = 1; i < num; i++) {
            if (arr[i].left <= arr[i - 1].right) {
                arr[i].left = arr[i - 1].left;
                arr[i].right = Math.max(arr[i - 1].right, arr[i].right);
            } else {
                int[] interval = new int[]{arr[i-1].left, arr[i-1].right};
                tmpIntervals[count++] = interval;
            }
        }

        int[] interval = new int[]{arr[num - 1].left, arr[num - 1].right};
        tmpIntervals[count++] = interval;

        int[][] ansIntervals = new int[count][2];

        for (int i = 0; i < count; i++) {
            ansIntervals[i] = tmpIntervals[i];
        }

        return ansIntervals;
    }

    public static void main(String[] args) {
        int[] interval1 = new int[]{1,3};
        int[] interval2 = new int[]{2,6};
        int[] interval3 = new int[]{8,10};
        int[] interval4 = new int[]{15,18};

        int[][] intervals = new int[4][2];
        intervals[0] = interval1;
        intervals[1] = interval2;
        intervals[2] = interval3;
        intervals[3] = interval4;

        int[][] ans = new Problem056().merge(intervals);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + ", " + ans[i][1]);
        }
    }

}
