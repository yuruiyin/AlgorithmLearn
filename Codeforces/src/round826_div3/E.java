package round826_div3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class E {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private Boolean[] memo;

        private int[] arr;

        private int len;

        private List<Integer>[] indexListArr;

        private boolean dp(int curIdx) {
            if (curIdx == len) {
                return true;
            }

            if (curIdx == len - 1) {
                return false;
            }

            if (memo[curIdx] != null) {
                return memo[curIdx];
            }

            long curValue = arr[curIdx];
            if (curValue == len - curIdx - 1) {
                return true;
            }

            if (curValue > len - curIdx - 1) {
                // 不能选当前数字为数组的len，那就要找到下个能充当len的数字
                boolean res = false;
                List<Integer> indexList = indexListArr[curIdx];
                for (int i : indexList) {
                    boolean tmpRes = dp(i + 1);
                    if (tmpRes) {
                        res = true;
                        break;
                    }
                }
                memo[curIdx] = res;
                return res;
            }

            // curValue < len - curIdx - 1
            // 当前数字可以有两个选择，充当len，或者不充当len
            boolean lenRes = dp((int) (curIdx + curValue + 1));
            if (lenRes) {
                memo[curIdx] = true;
                return true;
            }

            // 不选当前数字为数组的len，那就要找到下个能充当len的数字
            boolean nonLenRes = false;
            List<Integer> indexList = indexListArr[curIdx];
            for (int i : indexList) {
                boolean tmpRes = dp(i + 1);
                if (tmpRes) {
                    nonLenRes = true;
                    break;
                }
            }

            memo[curIdx] = nonLenRes;
            return nonLenRes;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                len = in.nextInt();
                arr = new int[len];
                for (int i = 0; i < len; i++) {
                    arr[i] = in.nextInt();
                }

                indexListArr = new ArrayList[len];
                Arrays.setAll(indexListArr, value -> new ArrayList<>());
                for (int i = 0; i < len; i++) {
                    int l = i - arr[i];
                    if (l >= 0) {
                        indexListArr[l].add(i);
                    }
                }

                memo = new Boolean[len];
                boolean isOk = dp(0);
                out.println(isOk ? "YES" : "NO");
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
