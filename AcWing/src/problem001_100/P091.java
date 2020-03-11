package problem001_100;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P091 {

    static class Task {

        private int[][] weight;
        private int[][] memo;
        private int n;

        /**
         * 记忆化搜索
         * @param idx 当前节点编号
         * @param visited 标记访问过哪些节点，访问过第i个节点，则第i位为1，否则为0
         * @return 返回已经访问过若干节点的情况下，从idx出发的遍历完所有节点且最终到达第n-1节点的路径最小值
         */
        private int dp(int idx, int visited) {
            visited |= (1 << idx);
            // 判断visited低n-1位是否全为1，若是，则说明就剩下最后一个节点了。
            if (visited + 1 == (1 << (n - 1))) {
                return weight[idx][n-1];
            }

            if (memo[idx][visited] != -1) {
                return memo[idx][visited];
            }

            int ansMin = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                if ((visited & (1 << i)) != 0) {
                    continue;
                }

                int res = dp(i, visited) + weight[idx][i];
                if (res < ansMin) {
                    ansMin = res;
                }
            }

            memo[idx][visited] = ansMin;
            return ansMin;
        }

        // 思路 记忆化搜索，加位运算，因为n就等于20
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            weight = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    weight[i][j] = in.nextInt();
                }
            }

            memo = new int[n][1 << n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            out.println(dp(0, 0));
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
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
