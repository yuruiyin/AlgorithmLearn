/**
 * P1083_ac
 *
 * @author: yry
 * @date: 2020/3/21
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 借教室
 * https://www.luogu.com.cn/problemnew/solution/P1083
 */
public class P1083_ac {

    static class Task {

        private int[] need;
        private int[] diff;

        private boolean isOk(int x, int[] r, int[] d, int[] s, int[] t) {
            int n = r.length;
            Arrays.fill(need, 0);
            Arrays.fill(diff, 0);
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
            // 其中前mid条记录构成的每天的借教室个数只要存在一天需要借用的教室数大于当前可用的教室数的时候，则说明第mid条记录借不成功

            int low = 0;
            int high = m - 1;
            need = new int[n + 2];
            diff = new int[n + 2];
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

        public void solve(Input in) throws IOException {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                r[i] = in.nextInt();
            }

            int[] d = new int[m];
            int[] s = new int[m];
            int[] t = new int[m];
            for (int i = 0; i < m; i++) {
                d[i] = in.nextInt();
                s[i] = in.nextInt();
                t[i] = in.nextInt();
            }

            int res = getApplicant(r, d, s, t);
            if (res == 0) {
                System.out.println(0);
            } else {
                System.out.println(-1);
                System.out.println(res);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Task task = new Task();
        task.solve(input);
    }

    public static class Input {
        private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        public int nextInt() throws IOException {
            in.nextToken();
            return (int)in.nval;
        }
        public long nextLong() throws IOException {
            in.nextToken();
            return (long)in.nval;
        }
    }

}
