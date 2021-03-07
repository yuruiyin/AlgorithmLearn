package educational_round105;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        class Data {
            int idx;
            int value;
            Data(int idx, int value) {
                this.idx = idx;
                this.value = value;
            }
        }

        private int getBigger(Data[] datas, int i1, int i2, int[] visited) {
            Data data1 = null, data2 = null;
            for (int i = 0; i < 4; i++) {
                if (datas[i].idx == i1) {
                    data1 = datas[i];
                } else if (datas[i].idx == i2) {
                    data2 = datas[i];
                }
            }

            if (data1.value - visited[data1.idx] - visited[(data1.idx - 1 + 4) % 4] >= data2.value - visited[data2.idx] - visited[(data2.idx - 1 + 4) % 4]) {
                return i1;
            }
            return i2;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                Data[] datas = new Data[4];
                for (int i = 0; i < 4; i++) {
                    int x = in.nextInt();
                    datas[i] = new Data(i, x);
                }

                Arrays.sort(datas, new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o2.value - o1.value;
                    }
                });

                boolean isOk = true;

                int[] visited = new int[4];

                for (int i = 0; i < 4; i++) {
                    Data data = datas[i];

                    int left = n - visited[data.idx] - visited[(data.idx - 1 + 4) % 4];

                    if (data.value < n - left) {
                        isOk = false;
                        break;
                    }

                    int curLeft = data.value - (n - left);

                    if (curLeft == 0) {
                        continue;
                    }

                    if (curLeft == left) {
                        visited[data.idx] = 1;
                        visited[(data.idx - 1 + 4) % 4] = 1;
                    } else if (curLeft == left - 1) {
                        if (visited[data.idx] == 0 && visited[(data.idx - 1 + 4) % 4] == 0) {
                            // 选一个大的放
                            int biggerIdx = getBigger(datas, (data.idx + 1) % 4, (data.idx - 1 + 4) % 4, visited);
                            visited[(biggerIdx - 1 + 4) % 4] = 1;
                        }
                    }
                }

                if (isOk) {
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
