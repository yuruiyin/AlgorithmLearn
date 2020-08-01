package round658_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    static class Task {
        private void swap(char[] arr, int i, int j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        private void invert(char[] arr, int i) {
            arr[i] = arr[i] == '0' ? '1' : '0';
        }

        private void createData(char[] arr1, char[] arr2) {
            for (int i = 0; i < 100000; i++) {
                arr1[i] = i % 2 == 0 ? '0' : '1';
                arr2[i] = i % 2 == 0 ? '1' : '0';
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {

            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                char[] arr1 = in.next().toCharArray();
                char[] arr2 = in.next().toCharArray();
//                char[] arr1 = new char[100000];
//                char[] arr2 = new char[100000];
//                createData(arr1, arr2);

                List<Integer> list = new ArrayList<>();

                int invertCount = 0;
                int l = 0;
                int r = n - 1;
                boolean isFromRight = true;

                for (int i = n - 1; i >= 0; i--) {
                    int curNum1 = -1;
                    if (isFromRight) {
                        curNum1 = arr1[r];
                    } else {
                        curNum1 = arr1[l];
                    }

                    if (invertCount % 2 != 0) {
                        curNum1 = curNum1 == '0' ? '1' : '0';
                    }

                    if (curNum1 == arr2[i]) {
                        if (isFromRight) {
                            r--;
                        } else {
                            l++;
                        }
                        continue;
                    }

                    int firstNum1 = -1;
                    if (isFromRight) {
                        firstNum1 = arr1[l];
                    } else {
                        firstNum1 = arr1[r];
                    }

                    if (invertCount % 2 != 0) {
                        firstNum1 = firstNum1 == '0' ? '1' : '0';
                    }

                    if (firstNum1 == arr2[i]) {
                        // 第一位先处理
                        list.add(1);
                    }

                    list.add(i + 1);
                    invertCount++;
                    if (isFromRight) {
                        l++;
                    } else {
                        r--;
                    }
                    isFromRight = !isFromRight;
                }

                int size = list.size();
                if (size == 0) {
                    out.println(0);
                    continue;
                }

                out.print(size + " ");
                for (Integer num : list) {
                    out.print(num + " ");
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
