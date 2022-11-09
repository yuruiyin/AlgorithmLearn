package ARC149;

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
            int a;
            int b;
            Data(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }

        private int findFirstBiggerByBinarySearch(int[] tail, int n, int target) {
            int low = 0;
            int high = n - 1;
            // 从tail数组中找到第一个比nums[i]大的元素，然后更新tail数组，若找不到，则说明nums[i] 比tail数组所有元素都大，则totalMax可以加1
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target == tail[mid]) {
                    return -1;
                } else if (target < tail[mid]) {
                    if(mid == 0 || tail[mid - 1] < target) {
                        return mid;
                    }
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }

        public int lengthOfLISBinarySearch(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }

            int totalMax = 1;
            int[] tail = new int[n + 1];
            tail[0] = nums[0];

            for (int i = 1; i < n; i++) {
                int index = findFirstBiggerByBinarySearch(tail, totalMax, nums[i]);

                if (index == -1) {
                    // nums[i]与tail数组中某个值相等, 不理睬
                    continue;
                }

                if (index == totalMax) {
                    // 说明num[i]比tail数组所有都大
                    totalMax++;
                }

                tail[index] = nums[i];
            }

            return totalMax;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            Data[] datas = new Data[n];
            Arrays.setAll(datas, v -> new Data(0, 0));

            for (int i = 0; i < n; i++) {
                datas[i].a = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                datas[i].b = in.nextInt();
            }

            Arrays.sort(datas, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.a - o2.a;
                }
            });

            // 求b数组的最长上升子序列
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = datas[i].b;
            }

            int bLIS = lengthOfLISBinarySearch(b);
            out.println(bLIS + n);
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
