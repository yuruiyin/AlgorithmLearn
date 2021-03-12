package round706_div2;

import java.io.*;
import java.util.*;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long[] yArr = new long[n];
                List<Long> xLeftList = new ArrayList<>();
                List<Long> xRightList = new ArrayList<>();
                int yIdx = 0;
                for (int i = 0; i < 2 * n; i++) {
                    long value1 = in.nextInt();
                    long value2 = in.nextInt();
                    if (value1 == 0) {
                        yArr[yIdx++] = value2;
                    } else if (value2 == 0) {
                        if (value1 < 0) {
                            xLeftList.add(value1);
                        } else {
                            xRightList.add(value1);
                        }
                    }
                }

                sort(yArr);

                Collections.sort(xRightList, (o1, o2) -> (int) (o2 - o1));
                Collections.sort(xLeftList);

//                Collections.sort(xRightList, (o1, o2) -> (int) (o2 - o1));
//                Collections.sort(xLeftList);

                int l = 0;
                int r = n - 1;
                double ans = 0;
                int leftIdx = 0;
                int rightIdx = 0;
                while (l <= r) {
                    long yValue = 0;
                    if (Math.abs(yArr[l]) > Math.abs(yArr[r])) {
                        yValue = yArr[l];
                        l++;
                    } else {
                        yValue = yArr[r];
                        r--;
                    }

                    long xValue = 0;
                    if (leftIdx == xLeftList.size()) {
                        xValue = xRightList.get(rightIdx++);
                    } else if (rightIdx == xRightList.size()) {
                        xValue = xLeftList.get(leftIdx++);
                    } else {
                        if (Math.abs(xLeftList.get(leftIdx)) > Math.abs(xRightList.get(rightIdx))) {
                            xValue = xLeftList.get(leftIdx);
                            leftIdx++;
                        } else {
                            xValue = xRightList.get(rightIdx);
                            rightIdx++;
                        }
                    }

                    ans += Math.sqrt(xValue * xValue + yValue * yValue);
                }

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
