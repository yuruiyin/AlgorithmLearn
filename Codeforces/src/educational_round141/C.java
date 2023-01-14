package educational_round141;

import java.io.*;
import java.util.*;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        class Data {
            int winCount;
            int cost;
            Data(int winCount, int cost) {
                this.winCount = winCount;
                this.cost = cost;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long m = in.nextLong();
                Data[] datas = new Data[n];
                Data[] oldDatas = new Data[n];
                for (int i = 0; i < n; i++) {
                    datas[i] = new Data(i, in.nextInt());
                    oldDatas[i] = datas[i];
                }

                Arrays.sort(datas, new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o1.cost - o2.cost;
                    }
                });

                int preSum = 0;
                PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o2.cost - o1.cost;
                    }
                });

                Set<Data> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    preSum += datas[i].cost;
                    if (preSum > m) {
                        preSum -= datas[i].cost;
                        break;
                    }
                    heap.add(datas[i]);
                    set.add(datas[i]);
                }

                long left = m - preSum;
                TreeSet<Integer> treeSet = new TreeSet<>();
                int size = heap.size();
                treeSet.add(size);
                for (int i = n - 1; i >= 0; i--) {
                    if (set.contains(oldDatas[i])) {
                        treeSet.add(i);
                    } else {
                        if (heap.isEmpty()) {
                            treeSet.add(i + 1);
                            continue;
                        }
                        int diff = oldDatas[i].cost - heap.peek().cost;
                        if (diff <= left) {
                            heap.poll();
                            left -= diff;
                            treeSet.add(i);
                        } else {
                            treeSet.add(i + 1);
                        }
                    }
                }

                int i = 0;
                int targetIdx = -1;
                for (int rank : treeSet) {
                    if (rank == size) {
                        targetIdx = i;
                        break;
                    }
                    i++;
                }

                out.println(treeSet.size() - targetIdx);
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
