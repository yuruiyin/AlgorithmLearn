import java.util.List;

/**
 * LintCode1668
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode1668 {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int getAns(List<Interval> intervals) {
        // write your code here
        if (intervals.isEmpty()) {
            return 0;
        }

        intervals.sort((o1, o2) -> o1.start == o2.start ? o2.end - o1.end : o1.start - o2.start);

        Interval preCommonInterval = intervals.get(0);
        int size = intervals.size();
        int ans = 1;
        for (int i = 1; i < size; i++) {
            Interval curInterval = intervals.get(i);
            if (curInterval.start <= preCommonInterval.end) {
                // 有交集
                preCommonInterval = new Interval(preCommonInterval.start, Math.min(preCommonInterval.end, curInterval.end));
            } else {
                ans++;
                preCommonInterval = curInterval;
            }
        }

        return ans;
    }

}
