import java.io.*;
import java.util.StringTokenizer;

public class GetWorkIdUtils {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            while (true) {
                String str = in.next();
                if (str == null || str.isBlank()) {
                    break;
                }
                int firstIdx = str.indexOf("\"");
                int lastIdx = str.lastIndexOf("\"");
                String fileIdStr = str.substring(firstIdx + 1, lastIdx);
                StringBuilder sb = new StringBuilder();
                for (char c: fileIdStr.toCharArray()) {
                    if (c == ',') {
                        continue;
                    }
                    sb.append(c);
                }
                System.out.println(sb);
//                out.println(sb);
            }
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
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
