package contest.contest304;

import java.util.Arrays;

public class B {

    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int len = grades.length;
        int ans = 1;
        int preCount = 1;
        for (int i = 1; i < len;) {
            if (len - i <= preCount) {
                return ans;
            }
            i += preCount + 1;
            preCount++;
            ans++;
        }
        return ans;
    }

}
