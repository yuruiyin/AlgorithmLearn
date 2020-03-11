package round626;

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
            int n = in.nextInt();
            String str = in.next();

            int leftCount = 0;
            int rightCount = 0;
            char[] arr = str.toCharArray();
            for (int i = 0; i < n; i++) {
                if (arr[i] == '(') {
                    leftCount++;
                } else {
                    rightCount++;
                }
            }

            if (leftCount != rightCount) {
                out.println(-1);
                return;
            }

            Stack<Character> stack = new Stack<>();
            int ans = 0;

            for (int i = 0; i < n; ) {
                if (arr[i] == '(') {
                    stack.push('(');
                    i++;
                } else {
                    if (stack.isEmpty()) {
                        int rCount = 1;
                        int lCount = 0;
                        int end = i;
                        for (int j = i + 1; j < n; j++) {
                            if (arr[j] == '(') {
                                lCount++;
                            } else {
                                rCount++;
                            }

                            if (lCount == rCount) {
                                end = j;
                                break;
                            }
                        }

                        ans += (end - i + 1);
                        i = end + 1;
                    } else {
                        stack.pop();
                        i++;
                    }
                }
            }

            out.println(ans);

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
