package educational_round085;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                long n = in.nextLong();
                long l = in.nextLong();
                long r = in.nextLong();

                long sum = 0;
                // 若n = 4 则为1 2 1 3 1 4 2 3 2 4 3 4 1，是有规律的，先1开头，在2开头，直到n-1开头
                List<Long> list = new ArrayList<>();
                for (long i = n - 1; i >= 1; i--) {
                    sum += i * 2;
                    if (sum >= l) {
                        long diff = (sum - l) / 2;
                        long first = n - i; // pair的第一个
                        long second = n - diff;
                        if ((sum - l) % 2 == 1) {
                            // 从first开始
                            list.add(first);
                            if (r == l) {
                                break;
                            }
                            l++;
                        }

                        list.add(second);
                        second++;
                        l++;
                        if (second > n) {
                            first++;
                            if (first == n) {
                                first = 1;
                            }
                            second = first + 1;
                        }

                        for (long j = l; j <= r; j+=2) {
                            list.add(first);
                            if (j == r) {
                                break;
                            }
                            list.add(second);
                            second++;
                            if (second > n) {
                                first++;
                                if (first == n) {
                                    first = 1;
                                }
                                second = first + 1;
                            }
                        }

                        break;
                    }
                }

                if (list.isEmpty()) {
                    list.add(1L);
                }

                for (Long num : list) {
                    System.out.print(num + " ");
                }

                System.out.println();
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
