package grakn_2020;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long l = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                if (n == 1) {
                    double ans = 0;
                    if (arr[0] == l - arr[0]) {
                        ans = l / 2.0;
                    } else if (arr[0] > l - arr[0]) {
                        // 右边的先到flag的位置，加速
                        ans += l - arr[0];
                        double leftDis = l - 2 * (l - arr[0]);
                        ans += leftDis / 3;
                    } else {
                        // 左边的先到flag的位置
                        ans += arr[0];
                        double dis = l - 2 * arr[0];
                        ans += dis / 3;
                    }

                    out.println(ans);
                    continue;
                }

                int leftFlagIndex = 0;
                int rightFlagIndex = n - 1;
                double leftPos = 0;
                double rightPos = l;
                int leftSpeed = 1;
                int rightSpeed = 1;

                double ans = 0;
                while (leftFlagIndex <= rightFlagIndex) {
                    double leftDis = arr[leftFlagIndex] - leftPos;
                    double rightDis = rightPos - arr[rightFlagIndex];
                    if (leftDis * rightSpeed == rightDis * leftSpeed) {
                        double cost = leftDis * 1.0 / leftSpeed;
                        ans += cost;
                        leftSpeed++;
                        rightSpeed++;
                        leftPos = arr[leftFlagIndex];
                        rightPos = arr[rightFlagIndex];
                        leftFlagIndex++;
                        rightFlagIndex--;
                    } else if (leftDis * rightSpeed > rightDis * leftSpeed) {
                        // 左边的花的时间越久
                        double cost = rightDis * 1.0 / rightSpeed;
                        ans += cost;
                        rightSpeed++;
                        rightPos = arr[rightFlagIndex];
                        leftPos += leftSpeed * cost;
                        rightFlagIndex--;
                    } else {
                        // 右边花的时间久
                        double cost = leftDis * 1.0 / leftSpeed;
                        ans += cost;
                        leftSpeed++;
                        leftPos = arr[leftFlagIndex];
                        rightPos -= rightSpeed * cost;
                        leftFlagIndex++;
                    }
                }

                double dis = Math.abs(leftPos - rightPos);
                ans += dis / (leftSpeed + rightSpeed);
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
