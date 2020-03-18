import java.util.Comparator;
import java.util.List;

/**
 * LintCode920
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode920 {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        // sort
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int size = intervals.size();
        for (int i = 1; i < size; i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }

}
