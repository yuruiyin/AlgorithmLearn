package educational_round087;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C1 {

    static class Task {

        private double getLen(double eachAngle) {
            double angle = eachAngle / 2;
            double z = 2 * Math.sin(Math.toRadians(angle));
            return z;
        }

        private double getLeftLen(int leftCount, double eachAngle, double curAngle) {
            double tmpLen = 0;
            for (int i = 0; i < leftCount; i++) {
                tmpLen += Math.sin(Math.toRadians(curAngle));
                curAngle = eachAngle + curAngle - 180;
            }

            return tmpLen;
        }

        private double getAns(int n) {
            if (n == 2) {
                return 1.0;
            }

            if (n == 4) {
                return 2.414213562;
            }

            double angleSum = (2 * n - 2) * 180;
            double eachAngle = angleSum / (2 * n);

            if (n == 6) {
                double z = getLen(eachAngle);
                return 1 + 2 * Math.sqrt(z * z / 2);
            }

            int sideCount = n / 2 - 1;
            if (sideCount % 2 == 0) {
                // 侧边有偶数条
                double mid = getLen(eachAngle);
                int leftCount = (sideCount - 2) / 2;
                double tmpAngle = (180 - eachAngle) / 2.0;
                double curAngle = eachAngle - 90 - tmpAngle;
                double z = mid + 2 * getLeftLen(leftCount, eachAngle, curAngle);
                return 1 + 2 * Math.sqrt(z * z / 2);
            }

            // 侧边有奇数条
            int leftCount = (sideCount - 1) / 2;
            double curAngle = eachAngle - 90;
            double z = 1 + 2 * getLeftLen(leftCount, eachAngle, curAngle);
            return 1 + 2 * Math.sqrt(z * z / 2);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                double ans = getAns(n);
                out.println(ans);
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
