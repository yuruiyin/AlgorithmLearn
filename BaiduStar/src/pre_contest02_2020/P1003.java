package pre_contest02_2020;

import java.io.*;
import java.util.*;

public class P1003 {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
//                List<Data>[] list = new ArrayList[n];
                List<Integer>[][] list = new ArrayList[101][11];
                for (int i = 0; i < n; i++) {
                    int pathLen = in.nextInt();
                    for (int j = 0; j < pathLen; j++) {
                        int time = in.nextInt();
                        int p = in.nextInt();
                        if (list[time][p] == null) {
                            list[time][p] = new ArrayList<>();
                        }

                        list[time][p].add(i);
                    }
                }

                Set<Integer> set = new HashSet<>();
                set.add(0);

                for (int i = 1; i <= 100; i++) {
                    for (int j = 1; j <= 10; j++) {
                        List<Integer> personList = list[i][j];
                        if (personList == null) {
                            continue;
                        }

                        boolean hasLight = false;
                        for (Integer person : personList) {
                            if (set.contains(person)) {
                                hasLight = true;
                                break;
                            }
                        }

                        if (hasLight) {
                            set.addAll(personList);
                        }
                    }
                }

                List<Integer> ansList = new ArrayList<>(set);
                Collections.sort(ansList);
                int size = ansList.size();
                for (int i = 0; i < size; i++) {
                    int person = ansList.get(i);
                    if (i == size - 1) {
                        out.println(person + 1);
                    } else {
                        out.print((person + 1) + " ");
                    }
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
