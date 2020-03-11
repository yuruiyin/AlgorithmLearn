package problem001_100;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P095 {

    static class Task {

        private int[] memo;

        private List<Integer> getNeighborIndexList(int i) {
            List<Integer> indexList = new ArrayList<>();
            int row = i / 5;
            int col = i % 5;
            if (row > 0) {
                // 有上
                indexList.add(i - 5);
            }

            if (row < 4) {
                // 有下
                indexList.add(i + 5);
            }

            if (col > 0) {
                // 有左
                indexList.add(i - 1);
            }

            if (col < 4) {
                // 右边
                indexList.add(i + 1);
            }

            return indexList;
        }

        private List<Integer> getIndexList(int i) {
            List<Integer> indexList = new ArrayList<>();
            int row = i / 5;
            int col = i % 5;

            if (row < 4) {
                // 有下
                indexList.add(i + 5);
            }

            if (row == 0 && col < 4) {
                // 右边
                indexList.add(i + 1);
            }

            return indexList;
        }

        private int dp(int grid, int level) {
//            System.out.println(Integer.toBinaryString(grid));
            if (grid + 1 == (1 << 25)) {
                // 全为1，即灯全亮了
                return 0;
            }

            if (level >= 6) {
                return 7;
            }

            if (memo[grid] != -1) {
                return memo[grid];
            }

            // 找到所有0的位置
            int ansMin = 7;
            for (int i = 0; i < 25; i++) {
                if ((grid & (1 << i)) != 0) {
                    continue;
                }

                // 上下左右或者自己变
                List<Integer> indexList = getIndexList(i);
                if (i / 5 == 0 && i % 5 == 0) {
                    indexList.add(i);
                }

                for (Integer curI : indexList) {
                    int grid1 = grid;
                    grid1 ^= (1 << curI);
                    List<Integer> neighborIndexList = getNeighborIndexList(curI);
                    for (Integer index: neighborIndexList) {
                        grid1 ^= (1 << index);
                    }

                    int res1 = dp(grid1, level + 1);
                    if (res1 > 6) {
                        continue;
                    }

                    ansMin = Math.min(ansMin, res1);
                }

                break;
            }

            memo[grid] = ansMin + 1;
            return memo[grid];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            memo = new int[1 << 25];
            while ((n--) > 0) {
                int grid = 0;
                for (int i = 0; i < 5; i++) {
                    String rowStr = in.next();
                    for (int j = 0; j < rowStr.length(); j++) {
                        char c = rowStr.charAt(j);
                        if (c == '1') {
                            grid += 1 << (i * 5 + j);
                        }
                    }
                }

                Arrays.fill(memo, -1);
                int res = dp(grid, 0);
                if (res > 6) {
                    out.println(-1);
                } else {
                    out.println(res);
                }

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
