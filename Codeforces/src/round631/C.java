package round631;

import java.io.*;
import java.util.*;

public class C {

    static class Task {

        class Data {
            int l;
            int index;
            Data(int l, int index) {
                this.l = l;
                this.index = index;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 优先队列
            int n = in.nextInt();
            int m = in.nextInt();
            int[] lArr = new int[m];
            long sum = 0;
            for (int i = 0; i < m; i++) {
                lArr[i] = in.nextInt();
                sum += lArr[i];
            }

            if (sum < n) {
                out.println(-1);
                return;
            }

//            int nextIndex = 0;
//            List<Data> list = new ArrayList<>();
//            PriorityQueue<Data> heap = new PriorityQueue<>();
//            long sum = 0;
//            for (int i = 0; i < m; i++) {
//                Data data = new Data(lArr[i], i);
//                list.add(data);
//                heap.offer(data);
//                if (sum + lArr[i] >= n) {
//                    nextIndex = i + 1;
//                    break;
//                }
//
//                sum += lArr[i];
//            }
//
//            list.sort(Comparator.comparingInt(o -> o.l));

            Data[] datas = new Data[m];
            for (int i = 0; i < m; i++) {
                datas[i] = new Data(lArr[i], i);
            }

            Arrays.sort(datas, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.l - o2.l;
                }
            });

            int[] ansArr = new int[m];

            int left = 1;
            int right = n;
            int index = 0;
            while (left < right) {
                int l = datas[index].l;

            }

            ansArr[datas[0].index] = 1;
            int pre = 2;
            boolean isOk = true;
            for (int i = 1; i < m; i++) {
                if (pre + lArr[i] - 1 > n) {
                    isOk = false;
                    break;
                }

                ansArr[datas[i].index] = pre;
                pre++;
            }

            if (!isOk) {
                out.println(-1);
                return;
            }

            for (int i = 0; i < m; i++) {
                out.print(ansArr[i] + " ");
            }
            out.println();
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
