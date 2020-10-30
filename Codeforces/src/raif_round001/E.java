package raif_round001;

import java.io.*;
import java.util.*;

public class E {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
            int[] arr = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                heap.add(arr[i]);
                sum += arr[i];
            }

            int aver = (int) (sum / k);
            int mod = (int) (sum % k);
            int count = k;

            for (int i = 0; i < n; i++, mod--) {
                if (mod <= 0) {
                    if (arr[i] <= aver) {
                        count--;
                        sum -= arr[i];
                    }
                } else {
                    if (arr[i] <= aver + 1) {
                        count--;
                        sum -= arr[i];
                    }
                }
            }

            List<Integer> removeList = new ArrayList<>();

            while (heap.size() + removeList.size() < k) {
                aver = (int) (sum / count);
                mod = (int) (sum % count);
                boolean isDivide = (mod == 0);
                if (!isDivide) {
                    aver++;
                }

                int max = heap.poll();
                if (max == aver) {
                    aver--;
                }
                removeList.add(aver);
                heap.add(max - aver);
                if (max - aver == aver) {
                    if (aver > sum / count && mod > 1) {
                        count--;
                        sum -= max;
                    } else {
                        sum -= aver;
                    }
                } else if (max - aver < aver) {
                    count--;
                    sum -= max;
                } else {
                    sum -= aver;
                }
                count--;
            }

            long ans = 0;
            while (!heap.isEmpty()) {
                long top = heap.poll();
                ans += top * top;
            }

            for (long num : removeList) {
                ans += num * num;
            }

            out.println(ans);
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
