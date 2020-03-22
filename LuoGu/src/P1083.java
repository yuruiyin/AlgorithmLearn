import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 借教室 在洛谷上提交居然会有些点会TLE和MLE，迷~
 * https://www.luogu.com.cn/problemnew/solution/P1083
 */
public class P1083 {

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

        public void solve(int testNumber, InputReader in, PrintWriter out) {
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
                out.println(0);
            } else {
                out.println(-1);
                out.println(res);
            }
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
