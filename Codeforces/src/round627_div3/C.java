package round627_div3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class C {
    
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
               String str = in.next();
               char[] arr = str.toCharArray();

               // 求最长的连续L即可
               int maxL = 0;
               int count = 0;
               for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == 'L') {
                        count++;
                    } else {
                        maxL = Math.max(maxL, count);
                        count = 0;
                    }
               }

               maxL = Math.max(maxL, count);
               out.println(maxL + 1);
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
