import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Problem147
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode147 {

    static class Task {

        private boolean isFlowerNum(int num, int n) {
            int sum = 0;
            int originNum = num;
            while (num > 0) {
                sum += Math.pow(num % 10, n);
                num /= 10;
            }
            return sum == originNum;
        }

        public List<Integer> getNarcissisticNumbers(int n) {
            int start = (int) Math.pow(10, n - 1);
            int end = (int) (Math.pow(10, n) - 1);
            List<Integer> ansList = new ArrayList<>();
            if (n == 1) {
                ansList.add(0);
            }
            for (int i = start; i <= end; i++) {
                if (isFlowerNum(i, n)) {
                    ansList.add(i);
                }
            }
            return ansList;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            List<Integer> list = getNarcissisticNumbers(in.nextInt());
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            out.println();
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
