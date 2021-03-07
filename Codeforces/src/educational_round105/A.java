package educational_round105;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class A {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private boolean isOk(char[] arr) {
            Stack<Character> stack = new Stack<>();
            for (char c : arr) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }

        private char[] getCharArr(char[] arr, int len, char c) {
            char[] map = new char[3];
            Arrays.fill(map, 'D');
            map[arr[0] - 'A'] = '(';
            map[arr[len - 1] - 'A'] = ')';

            char[] charArr = new char[len];
            Arrays.fill(charArr, 'D');
            charArr[0] = '(';
            charArr[len - 1] = ')';

            for (int i = 1; i < len - 1; i++) {
                if (map[arr[i] - 'A'] == '(') {
                    charArr[i] = '(';
                } else if (map[arr[i] - 'A'] == ')') {
                    charArr[i] = ')';
                } else {
                    charArr[i] = c;
                }
            }
            return charArr;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                char[] arr = in.next().toCharArray();
                int len = arr.length;

                if (arr[0] == arr[len - 1]) {
                    out.println("NO");
                    continue;
                }

                int[] countArr = new int[3];
                for (char c : arr) {
                    countArr[c - 'A']++;
                }

                boolean isOk = true;
                for (int i = 0; i < 3; i++) {
                    if (countArr[i] > len / 2) {
                        isOk = false;
                        break;
                    }
                }

                if (!isOk) {
                    out.println("NO");
                    continue;
                }

                char[] charArr1 = getCharArr(arr, len, '(');
                char[] charArr2 = getCharArr(arr, len, ')');

                if (isOk(charArr1) || isOk(charArr2)) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }

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

    private static void sortDesc(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
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
