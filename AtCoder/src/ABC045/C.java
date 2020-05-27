package ABC045;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private int len;
        private char[] arr;
        private List<Long> ansList;

        private long listToNum(List<Long> list) {
            long ans = 0;
            for (long num : list) {
                ans += num;
            }
            return ans;
        }

        private void dfs(long pre, int idx, List<Long> tmpList) {
            if (idx == len) {
                tmpList.add(pre);
                ansList.add(listToNum(tmpList));
                tmpList.remove(tmpList.size() - 1);
                return;
            }

            int curNum = arr[idx] - '0';
            dfs(pre * 10 + curNum, idx + 1, tmpList);
            tmpList.add(pre);
            dfs(curNum, idx + 1, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            arr = in.next().toCharArray();
            len = arr.length;

            ansList = new ArrayList<>();
            dfs(arr[0] - '0', 1, new ArrayList<>());
            long ans = 0;
            for (long num : ansList) {
                ans += num;
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
