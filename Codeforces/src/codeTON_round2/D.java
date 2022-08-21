package codeTON_round2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                 int n = in.nextInt();
                 int m = in.nextInt();
                 long[][] c = new long[n][m];
                 for (int i = 0; i < n; i++) {
                     for (int j = 0; j < m; j++) {
                         c[i][j] = in.nextLong();
                     }
                 }

                 int leftSameCount = 0;
                 for (int j = 0; j < m; j++) {
                     boolean isSame = true;
                     for (int i = 1; i < n; i++) {
                         if (c[i][j] != c[i - 1][j]) {
                             isSame = false;
                             break;
                         }
                     }
                     if (!isSame) {
                         break;
                     }
                     leftSameCount++;
                 }

                int rightSameCount = 0;
                for (int j = m - 1; j >= 0; j--) {
                    boolean isSame = true;
                    for (int i = 1; i < n; i++) {
                        if (c[i][j] != c[i - 1][j]) {
                            isSame = false;
                            break;
                        }
                    }
                    if (!isSame) {
                        break;
                    }
                    rightSameCount++;
                }

                int count = m - leftSameCount - rightSameCount;
                long sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += c[0][j];
                }
                long aver = sum / count;
                int specialIdx = 0;
                long ansCount = 0;
                for (int i = 0; i < n; i++) {
                    boolean isFound = false;
                    long diffSum = 0;
                    for (int j = leftSameCount; j < m - rightSameCount; j++) {
                        long diff = c[i][j] - aver;
                        diffSum += Math.abs(diff);
                        if (diff == 0) {
                            continue;
                        } else if (diff > 0) {
                            c[i][j + 1] += diff;
                        } else {
                            // diff < 0
                            if (c[i][j + 1] + c[i][j] < 2 * aver) {
                                // 找到
                                specialIdx = i + 1;
                                isFound = true;
                                break;
                            } else {
                                c[i][j + 1] += diff;
                            }
                        }
                    }

                    if (isFound) {
                        ansCount = diffSum;
                        break;
                    }
                }
                out.println(specialIdx + " " + ansCount);
            }
        }
    }

    private static void sort(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
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
