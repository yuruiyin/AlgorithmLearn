package round827_div4;

import java.io.*;
import java.util.*;

public class G {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        class Data {
            int oldNum;
            int newNum;
            Data(int oldNum, int newNum) {
                this.oldNum = oldNum;
                this.newNum = newNum;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
//                Data[] datas = new Data[n];
                PriorityQueue<Data> dataHeap = new PriorityQueue<>(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o2.newNum - o1.newNum;
                    }
                });
                for (int i = 0; i < n; i++) {
                    int num = in.nextInt();
                    dataHeap.add(new Data(num, num));
                }

                int[] ansArr = new int[n];
                ansArr[0] = dataHeap.poll().oldNum;
                int bitCount = 0;
                int num = ansArr[0];
                while (num > 0) {
                    num >>>= 1;
                    bitCount++;
                }
                int idx = 1;
                for (int i = bitCount - 1; i >= 0; i--) {
                    if (dataHeap.isEmpty()) {
                        break;
                    }
                    PriorityQueue<Data> tmpDataHeap = new PriorityQueue<>(new Comparator<Data>() {
                        @Override
                        public int compare(Data o1, Data o2) {
                            return o2.newNum - o1.newNum;
                        }
                    });
                    for (Data data : dataHeap) {
                        int newNum = data.newNum & (~ansArr[idx - 1]);
                        tmpDataHeap.add(new Data(data.oldNum, newNum));
                    }
                    ansArr[idx++] = tmpDataHeap.poll().oldNum;
                    dataHeap = tmpDataHeap;
                }

                while (!dataHeap.isEmpty()) {
                    ansArr[idx++] = dataHeap.poll().oldNum;
                }

                for (int i = 0; i < n; i++) {
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
