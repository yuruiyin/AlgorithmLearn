package round635_div2;

import java.io.*;
import java.util.*;

public class D {

    static class Task {

        private int[] getArr(int n, InputReader in) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            return arr;
        }

        private int findFirstBigger(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = arr[mid];
                if (midVal > target) {
                    if (mid == 0 || arr[mid - 1] <= target) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        private int findLastSmaller(int[] arr, int target) {
            int len = arr.length;
            int low = 0;
            int high = len - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = arr[mid];
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

        private int find(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = arr[mid];
                if (midVal == target) {
                    return mid;
                } else if (midVal > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        private long getValue(long x, long y, long z) {
            return (x - y) * (x - y) + (y - z) * (y - z) + (z - x) * (z - x);
        }

        private long getAns(int[] arr1, int[] arr2, int[] arr3) {
            // 先arr2，后arr3
            long ansMin = Long.MAX_VALUE;
            for (int num1 : arr1) {
                int equalIndex = find(arr2, num1);
                int firstBiggerIndex = findFirstBigger(arr2, num1);
                int lastSmallerIndex = findLastSmaller(arr2, num1);

                List<Integer> num2IndexList = new ArrayList<>(List.of(equalIndex, firstBiggerIndex, lastSmallerIndex));
                for (Integer num2Index : num2IndexList) {
                    if (num2Index < 0) {
                        continue;
                    }

                    int num2 = arr2[num2Index];
                    // 再求最接近的num3
                    int equalIndex3 = find(arr3, num2);
                    int firstBiggerIndex3 = findFirstBigger(arr3, num2);
                    int lastSmallerIndex3 = findLastSmaller(arr3, num2);

                    List<Integer> num3IndexList = new ArrayList<>(List.of(equalIndex3, firstBiggerIndex3, lastSmallerIndex3));

                    for (Integer num3Index : num3IndexList) {
                        if (num3Index < 0) {
                            continue;
                        }

                        int num3 = arr3[num3Index];
                        ansMin = Math.min(ansMin, getValue(num1, num2, num3));
                    }
                }
            }

            return ansMin;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int nr = in.nextInt();
                int ng = in.nextInt();
                int nb = in.nextInt();
                int[] rArr = getArr(nr, in);
                int[] gArr = getArr(ng, in);
                int[] bArr = getArr(nb, in);

                sort(rArr);
                sort(gArr);
                sort(bArr);

                long min1 = getAns(rArr, gArr, bArr);
                long min2 = getAns(rArr, bArr, gArr);
                long min3 = getAns(gArr, rArr, bArr);
                long min4 = getAns(gArr, bArr, rArr);
                long min5 = getAns(bArr, rArr, gArr);
                long min6 = getAns(bArr, gArr, rArr);

                List<Long> minList = new ArrayList<>(List.of(min1, min2, min3, min4, min5, min6));
                out.println(Collections.min(minList));
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
