package pre_contest01_2020;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1002 {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int total = in.nextInt();
                double[] scores = new double[101];
//                95~100 4.3
//
//                90~94 4.0
//
//                85~89 3.7
//
//                80~84 3.3
//
//                75~79 3.0
//
//                70~74 2.7
//
//                67~69 2.3
//
//                65~66 2.0
//
//                62~64 1.7
//
//                60~61 1.0
//
//                0~59 0
                for (int i = 0; i<= 59; i++) {
                    scores[i] = 0;
                }

                for (int i = 60; i <= 61; i++) {
                    scores[i] = 1.0;
                }

                for (int i = 62; i <= 64; i++) {
                    scores[i] = 1.7;
                }

                for (int i = 65; i <= 66; i++) {
                    scores[i] = 2.0;
                }

                for (int i = 67; i <= 69; i++) {
                    scores[i] = 2.3;
                }

                for (int i = 70; i <= 74; i++) {
                    scores[i] = 2.7;
                }

                for (int i = 75; i <= 79; i++) {
                    scores[i] = 3.0;
                }

                for (int i = 80; i <= 84; i++) {
                    scores[i] = 3.3;
                }

                for (int i = 85; i <= 89; i++) {
                    scores[i] = 3.7;
                }

                for (int i = 90; i <= 94; i++) {
                    scores[i] = 4.0;
                }

                for (int i = 95; i <= 100; i++) {
                    scores[i] = 4.3;
                }

                double ansMax = 0.0;
                for (int x1 = 0; x1 <= 100; x1++) {
                    if (x1 > total) {
                        break;
                    }

                    for (int x2 = x1; x2 <= 100; x2++) {
                        if (x1 + x2 > total) {
                            break;
                        }

                        for (int x3 = x2; x3 <= 100; x3++) {
                            if (x1 + x2 + x3 > total) {
                                break;
                            }

                            for (int x4 = x3; x4 <= 100; x4++) {
                                int sum = x1 + x2 + x3 + x4;
                                if (sum > total) {
                                    break;
                                }

                                if (sum != total) {
                                    continue;
                                }

                                double score = scores[x1] + scores[x2] + scores[x3] + scores[x4];
                                if (score > ansMax) {
                                    ansMax = score;
                                }
                            }
                        }
                    }
                }

                out.println(String.format("%.1f", ansMax));
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
