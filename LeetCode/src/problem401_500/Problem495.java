package problem401_500;

public class Problem495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int ans = duration;
        int pre = timeSeries[0] + duration;
        for (int i = 1; i < len; i++) {
            if (timeSeries[i] >= pre) {
                ans += duration;
            } else {
                ans += duration - (pre - timeSeries[i]);
            }
            pre = timeSeries[i] + duration;
        }
        return ans;
    }

}
