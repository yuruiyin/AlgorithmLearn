package contest.contest182;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/29
 */
public class B {

    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k] || rating[i] > rating[j] && rating[j] > rating[k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
