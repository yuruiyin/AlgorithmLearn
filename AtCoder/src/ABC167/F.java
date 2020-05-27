package ABC167;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class F {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            char[][] arr = new char[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = in.next().toCharArray();
            }

            int leftCount = 0;
            int rightCount = 0;
            for (int i = 0; i < n; i++) {
                Stack<Character> stack = new Stack<>();
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == '(') {
                        stack.push(arr[i][j]);
                    } else {
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                            continue;
                        }

                        stack.push(')');
                    }
                }

                if (stack.isEmpty()) {
                    continue;
                }

                int curLeftCount = 0;
                int curRightCount = 0;
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '(') {
                        curLeftCount++;
                    } else {
                        curRightCount++;
                    }
                }

                // 放左边
                int nextLeftCount1 = leftCount + (curLeftCount <= rightCount ? 0 : curLeftCount - rightCount);
                int nextRightCount1 = curRightCount + (rightCount <= curLeftCount ? 0 : rightCount - curLeftCount);

                // 放右边
                int nextLeftCount2 = curLeftCount + (leftCount <= curRightCount ? 0 : leftCount - curRightCount);
                int nextRightCount2 = rightCount + (curRightCount <= leftCount ? 0 : curRightCount - leftCount);

                if (nextLeftCount1 + nextRightCount1 <= nextLeftCount2 + nextRightCount2) {
                    leftCount = nextLeftCount1;
                    rightCount = nextRightCount1;
                } else {
                    leftCount = nextLeftCount2;
                    rightCount = nextRightCount2;
                }
            }

            if (leftCount == 0 && rightCount == 0) {
                out.println("Yes");
            } else {
                out.println("No");
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
