public class Problem057 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] tmpIntervals = new int[n + 1][2];

        if (n == 0) {
            return new int[][]{newInterval};
        }

        int num = 0;
        boolean isNewIntervalAdded = false;
        for (int i = 0; i < n; i++) {
            int[] curInterval = intervals[i];
            if (curInterval[0] < newInterval[0]) {
                tmpIntervals[num++] = curInterval;
            } else {
                if (!isNewIntervalAdded) {
                    tmpIntervals[num++] = newInterval;
                    isNewIntervalAdded = true;
                }
                tmpIntervals[num++] = curInterval;
            }
        }

        if (!isNewIntervalAdded) {
            tmpIntervals[num++] = newInterval;
            isNewIntervalAdded = true;
        }

        int[][] ansIntervals = new int[n + 1][2];
        int count = 0;
        for (int i = 1; i < num; i++) {
            if (tmpIntervals[i][0] <= tmpIntervals[i - 1][1]) {
                tmpIntervals[i][0] = tmpIntervals[i - 1][0];
                tmpIntervals[i][1] = Math.max(tmpIntervals[i - 1][1], tmpIntervals[i][1]);
            } else {
                ansIntervals[count++] = tmpIntervals[i - 1];
            }
        }

        ansIntervals[count++] = tmpIntervals[num - 1];

        int[][] newAnsIntervals = new int[count][2];
        System.arraycopy(ansIntervals, 0, newAnsIntervals, 0, count);

        return newAnsIntervals;
    }

    public static void main(String[] args) {
        int[] interval1 = new int[]{1,2};
        int[] interval2 = new int[]{3,5};
        int[] interval3 = new int[]{6,7};
        int[] interval4 = new int[]{8,10};
        int[] interval5 = new int[]{12,16};

        int[][] intervals = new int[5][2];
        intervals[0] = interval1;
        intervals[1] = interval2;
        intervals[2] = interval3;
        intervals[3] = interval4;
        intervals[4] = interval5;

        int[][] ans = new Problem057().insert(intervals, new int[]{4,8});

//        int[] interval1 = new int[]{1,5};
//        int[][] intervals = new int[1][2];
//        intervals[0] = interval1;
//
//        int[][] ans = new Problem057().insert(intervals, new int[]{2,7});

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + ", " + ans[i][1]);
        }
    }

}
