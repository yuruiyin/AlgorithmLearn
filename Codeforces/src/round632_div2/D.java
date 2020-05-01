package round632_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            String str = in.next();
            char[] arr = str.toCharArray();
            List<List<Integer>> ansList = new ArrayList<>();
            long RLCount = 0;
            while (true) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] == 'R' && arr[i + 1] == 'L') {
                        RLCount++;
                        list.add(i + 1);
                        arr[i] = 'L';
                        arr[i + 1] = 'R';
                        i++;
                    }
                }

                if (list.isEmpty()) {
                    break;
                }

                ansList.add(list);
            }

            if (ansList.size() > k || RLCount < k) {
                out.println(-1);
                return;
            }

            // 类似  10， 7，4
            int ansListSize = ansList.size();
            for (int cur = 0; cur < ansList.size(); cur++) {
                List<Integer> indexList = ansList.get(cur);
                int indexSize = indexList.size();
                for (int i = 0; i < indexSize; i++) {
                    if (ansListSize - cur < k) {
                        out.println(1 + " " + indexList.get(i));
                        k--;
                    } else {
                        out.print(indexSize - i + " ");
                        for (int j = i; j < indexSize; j++) {
                            out.print(indexList.get(j) + " ");
                        }
                        out.println();
                        k--;
                        break;
                    }
                }
            }
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
