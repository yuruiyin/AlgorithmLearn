import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class A {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] arr = new int[n];
                List<String> ansList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                if (n == 1) {
                    if (arr[0] == 0) {
                        out.println("a");
                        out.println("b");
                    } else {
                        for (int i = 0; i < 2; i++) {
                            out.println("a".repeat(arr[0]));
                        }
                    }
                    continue;
                }

                for (int i = 0; i < n; i++) {
                    if (i == 0) {
                        if (arr[i] == 0) {
                            ansList.add("z");
                        } else {
                            ansList.add("a".repeat(arr[i]));
                        }
                        continue;
                    }

                    if (arr[i-1] == 0) {
                        char[] preArr = ansList.get(i - 1).toCharArray();
                        char targetC = (char) (((preArr[0] - 'a' + 1) % 26) + 'a');
//                        for (char c = 'a'; c <= 'z'; c++) {
//                            if (c != preArr[0]) {
//                                targetC = c;
//                                break;
//                            }
//                        }

                        if (arr[i] == 0) {
                            ansList.add((targetC + ""));
                        } else {
                            ansList.add((targetC + "").repeat(arr[i]));
                        }

                        continue;
                    }

                    if (arr[i] >= arr[i - 1]) {
                        char[] preStr = ansList.get(i - 1).toCharArray();
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < arr[i-1]; j++) {
                            sb.append(preStr[j]);
                        }

                        if (arr[i-1] == preStr.length) {
                            for (int j = 0; j < arr[i] - arr[i-1]; j++) {
                                sb.append('b');
                            }
                        } else {
                            char targetC = (char) (((preStr[arr[i - 1]] - 'a' + 1) % 26) + 'a');
//                            char preNextChar = (char) ((preStr[arr[i - 1]] + 1) % 'z');
                            sb.append((targetC + "").repeat(arr[i] - arr[i-1]));
                        }

                        ansList.add(sb.toString());
                    } else {
                        ansList.add(ansList.get(i - 1).substring(0, arr[i-1]));
                    }
                }

                if (arr[n - 1] == 0) {
                    char[] preArr = ansList.get(n - 1).toCharArray();
                    char targetC = (char) (((preArr[0] - 'a' + 1) % 26) + 'a');

//                    for (char c = 'a'; c <= 'z'; c++) {
//                        if (c != preArr[0]) {
//                            targetC = c;
//                            break;
//                        }
//                    }

                    ansList.add((targetC + ""));
                } else {
                    ansList.add(ansList.get(n - 1).substring(0, arr[n - 1]));
                }

                for (String str : ansList) {
                    out.println(str);
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