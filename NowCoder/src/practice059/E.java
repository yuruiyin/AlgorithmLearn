package practice059;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }

            int q = in.nextInt();
            int diff = m - n;
            while ((q--) > 0) {
                int x = in.nextInt();
                int v = in.nextInt();
                arr[x - 1] = v;
                long[] tmpArr = new long[n];
                System.arraycopy(arr, 0, tmpArr, 0, n);

                if (n == 1) {
                    long aver = arr[0] / m;
                    long mod = arr[0] % m;
                    long ans = 0;
                    for (int i = 0; i < m; i++, mod--) {
                        long cur = aver;
                        if (mod > 0) {
                            cur++;
                        }
                        ans += cur * cur;
                    }

                    out.println(ans);
                    continue;
                }

                Arrays.sort(tmpArr);
                long ansMin = Long.MAX_VALUE - 100;
                for (int i = (int) (tmpArr[n-1] / (diff + 1)); i <= tmpArr[n - 1]; i++) {
                    int count = 0;
                    long sum = 0;
                    boolean isOk = false;
                    for (int j = n - 1; j >= 0; j--) {
                        // 从大到小遍历，看每个数组拆分出i，可以多贡献出几堆，比如i = 4, tmpArr[j] = 7。那么7就可以多贡献1堆。
                        long tmpCount = tmpArr[j] % i == 0 ? tmpArr[j] / i - 1 : tmpArr[j] / i;
                        if (tmpCount == 0 || count + tmpCount > diff) {
                            isOk = true;
                            for (int k = 0; k <= j; k++) {
                                sum += tmpArr[k] * tmpArr[k];
                            }
                            break;
                        }

                        long aver = tmpArr[j] / (tmpCount + 1);
                        if (tmpArr[j] % (tmpCount + 1) == 0) {
                            sum += aver * aver * (tmpCount + 1);
                        } else {
                            sum += aver * aver * tmpCount + (tmpArr[j] - aver * tmpCount) * (tmpArr[j] - aver * tmpCount);
                        }

                        count += tmpCount;
                    }

                    ansMin = Math.min(ansMin, sum);

                    if (!isOk) {
                        break;
                    }
                }

                out.println(ansMin);
            }
        }
    }

    private static void createInput() {
        for (int i = 0; i < 399; i++) {
            System.out.print(1 + " ");
        }
        System.out.println("100000");
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
//        createInput();
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
