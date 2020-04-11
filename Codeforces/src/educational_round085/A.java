package educational_round085;

import java.io.*;
import java.util.StringTokenizer;

public class A {

    static class Task {

        class Data {
            int x;
            int y;
            Data(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                Data[] datas = new Data[n];
                for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    datas[i] = new Data(x, y);
                }

                if (datas[0].y > datas[0].x) {
                    out.println("No");
                    continue;
                }

                boolean isOk = true;
                for (int i = 1; i < n; i++) {
                    if (datas[i].x < datas[i - 1].x || datas[i].y < datas[i-1].y) {
                        isOk = false;
                        break;
                    }

                    if (datas[i].y - datas[i - 1].y > datas[i].x - datas[i-1].x) {
                        isOk = false;
                        break;
                    }

                    if (datas[i].y > datas[i].x) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
            }
        }
    }

    private static void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
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
