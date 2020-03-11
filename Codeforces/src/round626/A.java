package round626;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] arr = new int[n];

                List<Integer> oddIndexList = new ArrayList<>();
                List<Integer> evenIndexList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    if (arr[i] % 2 == 0) {
                        evenIndexList.add(i + 1);
                    } else {
                        oddIndexList.add(i + 1);
                    }
                }

                int oddCount = oddIndexList.size();
                int evenCount = evenIndexList.size();

                if (n == 1 && oddCount == 1) {
                    out.println(-1);
                    continue;
                }

                if (evenCount != 0) {
                    out.println(1);
                    out.println(evenIndexList.get(0));
                } else {
                    out.println(2);
                    out.println(oddIndexList.get(0) + " " + oddIndexList.get(1));
                }
            }
        }
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
