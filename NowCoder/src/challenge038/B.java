package challenge038;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B {

    static class Task {

        private void reverse(char[] arr, int left, int right) {
            while (left < right) {
                char t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                left++;
                right--;
            }
        }

        class Data {
            int x;
            int count;
            Data(int x, int count) {
                this.x = x;
                this.count = count;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            String str = in.next();
            char[] arr = str.toCharArray();
            LinkedList<Data> xList = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            while ((q--) > 0) {
                int op = in.nextInt();
                int pos = in.nextInt() - 1;
                if (op == 1) {
                    if (xList.isEmpty() || pos != xList.getLast().x) {
                        xList.offer(new Data(pos, 1));
                    } else if (pos == xList.getLast().x) {
                        xList.getLast().count++;
                    }
                } else {
                    if (xList.isEmpty()) {
                        sb.append(arr[pos]);
                        continue;
                    }

                    int min = xList.getFirst().x;
                    int max = xList.getLast().x + m - 1;
                    if (pos < min || pos > max) {
                        sb.append(arr[pos]);
                        continue;
                    }

                    while (!xList.isEmpty()) {
                        Data curData = xList.peek();
                        if (pos < curData.x) {
                            break;
                        }

                        xList.poll();
                        if (curData.count % 2 == 0) {
                            continue;
                        }

                        int left = curData.x;
                        int right = left + m - 1;
                        reverse(arr, left, right);
                    }

                    sb.append(arr[pos]);
                }
            }

            out.println(sb.toString());
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
