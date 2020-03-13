package problem001_100;

import java.io.*;
import java.util.*;

public class P095 {

    static class Task {

        private int grid;

        // 按下i位置的灯
        private void turn(int i) {
            int row = i / 5;
            int col = i % 5;
            grid ^= 1 << i;
            if (row > 0) {
                // 有上
                grid ^= 1 << (i - 5);
            }

            if (row < 4) {
                // 有下
                grid ^= 1 << (i + 5);
            }

            if (col > 0) {
                // 有左
                grid ^= 1 << (i - 1);
            }

            if (col < 4) {
                // 右边
                grid ^= 1 << (i + 1);
            }
        }

        private int getAns() {
            // 遍历第一行的32种点击状态
            int ansMin = 7;
            int originGrid = grid;
            for (int k = (1 << 5) - 1; k >= 0; k--) {
                this.grid = originGrid;
                int count = 0;
                for (int i = 0; i < 5; i++) {
                    if ((k >> i & 1) == 1) {
                        turn(i);
                        count++;
                    }
                }

                for (int i = 0; i < 20; i++) {
                    // 当前行有元素等于0，则按下一行同列上的灯
                    if ((grid & (1 << i)) == 0) {
                        turn(i + 5);
                        count++;
                        if (count >= ansMin) {
                            break;
                        }
                    }
                }

                // 判断grid是否已经是全1
                if (grid + 1 == (1 << 25) && count < ansMin) {
                    ansMin = count;
                }
            }

            return ansMin <= 6 ? ansMin : -1;
        }

        // 思路：第一行单独处理，而且同一张灯只能改变一次。除了第一行，其它行需要操作下一行让灯亮起来。
        // 也就是从第一行到最后一行，一行一行的让灯亮起来。
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            while ((n--) > 0) {
                grid = 0;
                for (int i = 0; i < 5; i++) {
                    String rowStr = in.next();
                    for (int j = 0; j < rowStr.length(); j++) {
                        char c = rowStr.charAt(j);
                        if (c == '1') {
                            grid += 1 << (i * 5 + j);
                        }
                    }
                }

                out.println(getAns());
            }
        }
    }

    private static void createInput() {
        int MAXN = 500;
        Random random = new Random();
        for (int i = 0; i < MAXN; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(random.nextInt(2));
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        createInput();
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
