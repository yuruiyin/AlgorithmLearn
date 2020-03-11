package contest.contest179;

public class Problem02_1 {

    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int curMax = 0;
        for (int i = 0; i < light.length; i++) {
            curMax = Math.max(curMax, light[i]);
            if (curMax == i + 1) {
                ans++;
            }
        }
        return ans;
    }

}
