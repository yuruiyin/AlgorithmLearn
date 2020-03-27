package round629_div3;

import java.io.*;
import java.util.StringTokenizer;

public class C {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                String str = in.next();
                StringBuilder a = new StringBuilder("1");
                StringBuilder b = new StringBuilder("1");
                boolean isEqual = true;
                for (int i = 1; i < str.length(); i++) {
                    int num = str.charAt(i) - '0';
                    if (num == 0) {
                        a.append('0');
                        b.append('0');
                    } else if (num == 1) {
                        if (isEqual) {
                            a.append('1');
                            b.append('0');
                            isEqual = false;
                        } else {
                            a.append('0');
                            b.append('1');
                        }
                    } else {
                        if (isEqual) {
                            a.append('1');
                            b.append('1');
                        } else {
                            a.append('0');
                            b.append('2');
                        }
                    }
                }

                out.println(a);
                out.println(b);
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
