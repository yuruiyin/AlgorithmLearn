package ABC164;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            // S, T, U, V
            long[] s = new long[n];
            long[] t = new long[n];
            long[] u = new long[n];
            long[] v = new long[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextLong();
            }
            for (int i = 0; i < n; i++) {
                t[i] = in.nextLong();
            }
            for (int i = 0; i < n; i++) {
                u[i] = in.nextLong();
            }
            for (int i = 0; i < n; i++) {
                v[i] = in.nextLong();
            }

            long[][] ansGrid = new long[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(ansGrid[i], -1);
            }

            boolean[] atLeastOneZeroRow = new boolean[n]; // 当前行至少有一个0
            long[] mustValueRow = new long[n]; // 某一行必须为某个value 或0
            Arrays.fill(mustValueRow, -1);

            for (int i = 0; i < n; i++) {
                if (s[i] == 0) {
                    // 第i行所有元素与等于ui
                    if (u[i] > 0) {
                        for (int j = 0; j < n; j++) {
                            ansGrid[i][j] = u[i];
                        }
                    } else {
                        // TODO, 与等于0，则当前行至少有一个元素为0
                        atLeastOneZeroRow[i] = true;
                    }
                } else {
                    // 第i行所有元素或等于ui
                    if (u[i] > 0) {
                        // 或等于u[i]，则当前行至少有一个元素为u[i]，其它都为0
                        mustValueRow[i] = u[i];
                    } else {
                        //或等于0，即所有元素等于0
                        for (int j = 0; j < n; j++) {
                            ansGrid[i][j] = 0;
                        }
                    }
                }
            }

            boolean isOk = true;
            for (int j = 0; j < n; j++) {
                if (t[j] == 0) {
                    // 第j列与等于vi, 每个元素都要为vi
                    if (v[j] > 0) {
                        for (int i = 0; i < n; i++) {
                            if (ansGrid[i][j] != -1 && ansGrid[i][j] != v[j]) {
                                isOk = false;
                                break;
                            }
                            ansGrid[i][j] = v[j];
                        }
                    } else {
                        // 第j列有一个元素为0即可
                        boolean tmpIsOk = false;
                        for (int i = 0; i < n; i++) {
                            if (ansGrid[i][j] == -1 || ansGrid[i][j] == 0) {
                                tmpIsOk = true;
                                break;
                            }
                        }
                        isOk = tmpIsOk;
                    }
                } else {
                    // 第j列或等于vi
                    if (v[j] > 0) {
                        for (int i = 0; i < n; i++) {
                            if (ansGrid[i][j] != -1 && ansGrid[i][j] != v[j]) {
                                isOk = false;
                                break;
                            }
                        }

                        if (isOk) {
                            for (int i = 0; i < n; i++) {
                                if (ansGrid[i][j] == -1) {
                                    ansGrid[i][j] = v[j];
                                }
                            }
                        }

                    } else {
                        // 第j列所有元素为0
                        for (int i = 0; i < n; i++) {
                            if (ansGrid[i][j] != -1 && ansGrid[i][j] != 0) {
                                isOk = false;
                                break;
                            }
                        }
                    }
                }

                if (!isOk) {
                    break;
                }
            }

            if (!isOk) {
                out.println(-1);
                return;
            }

            for (int i = 0; i < n; i++) {
                boolean hasZero = false;
                for (int j = 0; j < n; j++) {
                    if (ansGrid[i][j] == -1 || ansGrid[i][j] == 0) {
                        hasZero = true;
                    }
                }

                if (atLeastOneZeroRow[i] && !hasZero) {
                    isOk = false;
                    break;
                }
            }

            if (!isOk) {
                out.println(-1);
                return;
            }

            for (int i = 0; i < n; i++) {
                long curRowMustValue = mustValueRow[i];
                if (curRowMustValue == -1) {
                    continue;
                }

                boolean tmpIsOk = true;
                for (int j = 0; j < n; j++) {
                    if (ansGrid[i][j] != -1 && ansGrid[i][j] != curRowMustValue) {
                        tmpIsOk = false;
                        break;
                    }
                }

                if (!tmpIsOk) {
                    isOk = false;
                    break;
                }
            }

            if (!isOk) {
                out.println(-1);
                return;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ansGrid[i][j] == -1) {
                        out.print(0 + " ");
                    } else {
                        out.print(ansGrid[i][j] + " ");
                    }
                }
                out.println();
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

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
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
