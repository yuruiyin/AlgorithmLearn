/**
 * LintCode1680
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode1680 {

    private boolean isOk(int x, int[] r, int[] d, int[] s, int[] t) {
        int n = r.length;
        int[] need = new int[n];
        int[] diff = new int[n];
        for (int i = 0; i <= x; i++) {
            diff[s[i]] += d[i];
            diff[t[i] + 1] -= d[i];
        }

        for (int i = 1; i <= n; i++) {
            need[i] = need[i-1] + diff[i];
            if (need[i] > r[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public int getApplicant(int[] r, int[] d, int[] s, int[] t) {
        int n = r.length;
        int m = d.length;

        // 二分+差分, 二分枚举每个借教室记录，如果mid可以借成功，说明错误出现在后半部分(mid + 1 ~)，否则说明错误出现在前半部分(包含mid)
        // 而差分是为了快速求得被每天被借用的教室的个数，
        // 其中前mid条记录构成的每天的借教室个数只有存在一天需要借用的教室数大于当前可用的教室数的时候，则说明第mid条记录借不成功

        int low = 0;
        int high = m - 1;
        if (isOk(m - 1, r, d, s, t)) {
            return 0;
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (isOk(mid, r, d, s, t)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low + 1;
    }

}
