package ARC149;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class A_1 {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private boolean isRepeatNum(long num) {
            char[] arr = String.valueOf(num).toCharArray();
            Set<Character> set = new HashSet<>();
            for (char c: arr) {
                set.add(c);
            }
            return set.size() == 1;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long n = in.nextInt();
            long m = in.nextInt();
            Map<Integer, Long> countMap = new HashMap<>();
            for (int i = 1; i < 100000; i++) {
                long value = m * i;
                if (isRepeatNum(value)) {
                    int num = (int) (value % 10L);
                    if (countMap.getOrDefault(num, 0L) != 0) {
                        int tmpCount = String.valueOf(value).length();
                        if ((n / tmpCount) * tmpCount > countMap.get(num)) {
                            countMap.put(num, (n / tmpCount) * tmpCount);
                        }
                    } else {
                        int tmpCount = String.valueOf(value).length();
                        countMap.put(num, (n / tmpCount) * tmpCount);
                    }
                }
            }
            if (countMap.isEmpty()) {
                out.println(-1);
                return;
            }

            long maxCount = 0;
            for (int num : countMap.keySet()) {
                long count = countMap.get(num);
                maxCount = Math.max(maxCount, count);
            }

            if (maxCount == 0) {
                out.println(-1);
                return;
            }

            int maxNum = 1;
            for (int num : countMap.keySet()) {
                long count = countMap.get(num);
                if (count == maxCount && num >= maxNum) {
                    maxNum = num;
                }
            }

            out.println((maxNum + "").repeat((int) maxCount));
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
