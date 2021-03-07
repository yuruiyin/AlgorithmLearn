package round699_div2;

import java.io.*;
import java.util.*;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                int[] a = new int[n];
                int[] b = new int[n];
                int[] c = new int[m];
                Map<Integer, List<Integer>> bIndexListMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    b[i] = in.nextInt();
                    if (!bIndexListMap.containsKey(b[i])) {
                        bIndexListMap.put(b[i], new ArrayList<>());
                    }
                    bIndexListMap.get(b[i]).add(i);
                }

                Map<Integer, Integer> countMap = new HashMap<>();
                for (int i = 0; i < m; i++) {
                    c[i] = in.nextInt();
                    countMap.put(c[i], countMap.getOrDefault(c[i], 0) + 1);
                }

                Map<Integer, LinkedList<Integer>> indexListMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    if (a[i] != b[i]) {
                        if (!indexListMap.containsKey(b[i])) {
                            indexListMap.put(b[i], new LinkedList<>());
                        }
                        indexListMap.get(b[i]).add(i);
                    }
                }

                boolean isOk = true;
                for (int key : indexListMap.keySet()) {
                    int count = indexListMap.get(key).size();
                    if (countMap.getOrDefault(key, 0) < count) {
                        isOk = false;
                        break;
                    }
                }

                if (!isOk) {
                    out.println("NO");
                    continue;
                }

                if (!bIndexListMap.containsKey(c[m - 1])) {
                    out.println("NO");
                    continue;
                }

                int targetIdx = -1;
                if (indexListMap.containsKey(c[m - 1])) {
                    targetIdx = indexListMap.get(c[m  - 1]).get(indexListMap.get(c[m  - 1]).size() - 1);
                } else {
                    targetIdx = bIndexListMap.get(c[m  - 1]).get(bIndexListMap.get(c[m  - 1]).size() - 1);
                }

                int[] ansArr = new int[m];
                for (int i = 0; i < m; i++) {
                    if (!indexListMap.containsKey(c[i])) {
                        ansArr[i] = targetIdx + 1;
                    } else {
                        LinkedList<Integer> indexList = indexListMap.get(c[i]);
                        if (indexList.size() == 1) {
                            ansArr[i] = indexList.get(0) + 1;
                        } else {
                            ansArr[i] = indexList.getFirst() + 1;
                            indexList.removeFirst();
                        }
                    }
                }

                out.println("YES");
                for (int i = 0; i < m; i++) {
                    out.print(ansArr[i] + " ");
                }
                out.println();
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
