package educational_round115;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        class Dragon {
            long x;
            long y;
            Dragon(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }

        private int findFirstBiggerOrEqual(long[] arr, long target) {
            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target <= arr[mid]) {
                    if (mid == 0 || target > arr[mid - 1]) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

        private int findLastSmaller(long[] arr, long target) {
            int len = arr.length;
            int low = 0;
            int high = len - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                long midVal = arr[mid];
                if (midVal < target) {
                    if (mid == len - 1 || arr[mid + 1] >= target) {
                        return mid;
                    }
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] heros = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                heros[i] = in.nextLong();
                sum += heros[i];
            }

            sort(heros);

            int m = in.nextInt();
            Dragon[] dragons = new Dragon[m];
            for (int i = 0; i < m; i++) {
                dragons[i] = new Dragon(in.nextLong(), in.nextLong());
            }

            for (int i = 0; i < m; i++) {
                Dragon dragon = dragons[i];
                long x = dragon.x;
                long y = dragon.y;
                int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(heros, x);
                if (firstBiggerOrEqualIdx == -1) {
                    // 说明所有英雄的攻击力都比当前怪兽的防御力小
                    long ans = x - heros[n - 1] + Math.max(0, y - (sum - heros[n - 1]));
                    out.println(ans);
                } else {
                    if (heros[firstBiggerOrEqualIdx] == x) {
                        long ans =  Math.max(0, y - (sum - x));
                        out.println(ans);
                    } else {
                        if (sum - heros[firstBiggerOrEqualIdx] >= y) {
                            out.println(0);
                        } else {
                            int lastSmallerIndex = findLastSmaller(heros, x);
                            if (lastSmallerIndex == -1) {
                                long ans = Math.max(0, y - (sum - heros[firstBiggerOrEqualIdx]));
                                out.println(ans);
                            } else {
                                long value1 = y - (sum - heros[firstBiggerOrEqualIdx]);
                                long value2 = Math.max(0, y - (sum - heros[lastSmallerIndex])) + (x - heros[lastSmallerIndex]);
                                out.println(Math.min(value1, value2));
                            }
                        }
                    }
                }
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
