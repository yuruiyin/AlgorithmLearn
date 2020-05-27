package contest.contest189;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/17
 */
public class A {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }

        return ans;
    }

}
