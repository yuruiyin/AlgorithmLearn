package round829_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int dis = n / 2 ;
                int[] ansArr = new int[n];
                int oldN = n;
                if (n % 2 == 1) {
                    n--;
                }
                int mid = n / 2 + 1;
                ansArr[0] = mid - 1;
                ansArr[n - 1] = mid;
                int l = 1;
                int r = n;
                int flag = 0;
                int lidx = 1;
                int rIdx = n - 2;
                if (n >= 4) {
                    ansArr[1] = n;
                    ansArr[n - 2] = 1;
                }
                int idx = 2;
                for (int i = mid - 2; i >= 2; i--) {
                    ansArr[idx++] = i;
                    ansArr[idx++] = i + dis;
                }
//                while (l < r) {
//                    if (l == r - 1) {
//                        break;
//                    }
//                    if (flag == 0) {
//                        if (lidx == 1) {
//                            ansArr[lidx++] = r;
//                            ansArr[rIdx--] = l;
//
//                        }
//
//                        flag = 1;
//                    } else {
//                        ansArr[lidx++] = l;
//                        ansArr[rIdx--] = r;
//                        flag = 0;
//                    }
//                    l++;
//                    r--;
//                }

                if (oldN % 2 == 1) {
                    ansArr[oldN - 1] = oldN;
                }
                for (int i = 0; i < oldN; i++) {
                    out.print(ansArr[i] + " ");
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
