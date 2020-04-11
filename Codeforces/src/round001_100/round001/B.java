package round001_100.round001;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            while ((n--) > 0) {
                String str = in.next();
                char[] arr = str.toCharArray();
                int type = 0;
                for (int i = 2; i < arr.length; i++) {
                    if (Character.isDigit(arr[1]) && Character.isLetter(arr[i])) {
                        type = 1;
                        break;
                    }
                }

                if (type == 0) {
                    // 如BC23, 输出R23C55
                    int colNum = 0;
                    int rowNum = 0;
                    for (int i = 0; i < arr.length; i++) {
                        if (Character.isDigit(arr[i])) {
                            rowNum = Integer.parseInt(str.substring(i));
                            break;
                        }
                        colNum *= 26;
                        colNum += arr[i] - 'A' + 1;
                    }

                    out.println("R" + rowNum + "C" + colNum);
                } else {
                    // 如R23C55, 输出BC23
                    int rowNum = 0;
                    int i;
                    for (i = 1; i < arr.length; i++) {
                        if (Character.isLetter(arr[i])) {
                            break;
                        }
                        rowNum *= 10;
                        rowNum += arr[i] - '0';
                    }

                    int colNum = Integer.parseInt(str.substring(i + 1));
                    StringBuilder sb = new StringBuilder();
                    while (colNum > 0) {
                        colNum--;
                        sb.append((char)(colNum % 26 + 'A'));
                        colNum /= 26;
                    }

                    out.println(sb.reverse().toString() + rowNum);
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
