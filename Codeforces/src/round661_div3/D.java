package round661_div3;

import java.io.*;
import java.util.*;

public class D {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                char[] arr = in.next().toCharArray();

                LinkedList<List<Integer>> oneList = new LinkedList<>();
                LinkedList<List<Integer>> zeroList = new LinkedList<>();

                for (int i = 0; i < n; i++) {
                    if (arr[i] == '0') {
                        // 找1
                        if (oneList.isEmpty()) {
                            List<Integer> list = new ArrayList<>();
                            list.add(i);
                            zeroList.add(list);
                        } else {
                            List<Integer> list = oneList.poll();
                            list.add(i);
                            zeroList.add(list);
                        }
                    } else {
                        // 找0
                        if (zeroList.isEmpty()) {
                            List<Integer> list = new ArrayList<>();
                            list.add(i);
                            oneList.add(list);
                        } else {
                            List<Integer> list = zeroList.poll();
                            list.add(i);
                            oneList.add(list);
                        }
                    }
                }

                out.println(oneList.size() + zeroList.size());
                int[] ansArr = new int[n];
                int count = 1;
                for (List<Integer> indexList : oneList) {
                    for (Integer index : indexList) {
                        ansArr[index] = count;
                    }
                    count++;
                }

                for (List<Integer> indexList : zeroList) {
                    for (Integer index : indexList) {
                        ansArr[index] = count;
                    }
                    count++;
                }
                
                for (int i = 0; i < n; i++) {
                    out.print(ansArr[i] + " ");
                }
                out.println();;
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
