package educational_round137;

import java.io.*;
import java.util.*;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        class Data {
            int originIdx;
            int curIdx;
            Data(int originIdx, int curIdx) {
                this.originIdx = originIdx;
                this.curIdx = curIdx;
            }

        }

        private String getMax(char[] arr1, List<Integer> zeroIndexList, int firstOneIdx) {
            if (firstOneIdx > zeroIndexList.get(0)) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            int len = arr1.length;
            for (int i = 0; i < len; i++) {
                sb.append(arr1[i]);
            }
            sb.setCharAt(zeroIndexList.get(0), '1');
            int size = zeroIndexList.size();
            int preOneIdx = firstOneIdx;
            for (int i = 1; i < size; i++) {
                int diff = zeroIndexList.get(i) - zeroIndexList.get(i - 1);
                if (preOneIdx + diff >= len) {
                    break;
                }
                if (arr1[preOneIdx + diff] == '1') {
                    sb.setCharAt(zeroIndexList.get(i), '1');
                }
                preOneIdx += diff;
            }
            return sb.toString();
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String str = in.next();
            char[] arr = str.toCharArray();
            // 先计算第一个1的位置
            int firstOneIdx = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] == '1') {
                    firstOneIdx = i;
                    break;
                }
            }

            if (firstOneIdx == -1) {
                // 全0
                out.println(0);
                return;
            }

            String str1 = str.substring(firstOneIdx);
            char[] arr1 = str1.toCharArray();
            int len = arr1.length;

            // 记录0的位置
            List<Integer> zeroIndexList = new ArrayList<>();
            Set<Integer> oneIdxSet = new HashSet<>();
            for (int i = 0; i < len; i++) {
                if (arr1[i] == '0') {
                    zeroIndexList.add(i);
                } else {
                    oneIdxSet.add(i);
                }
            }

            if (zeroIndexList.isEmpty()) {
                // 全1
                out.println(str1);
                return;
            }

            int size = zeroIndexList.size();
            if (size == 1) {
                out.println("1".repeat(len));
                return;
            }

            List<Data> oneIndexList = new ArrayList<>();
            for (int i = 0; i < zeroIndexList.get(0); i++) {
                if (arr1[i] == '1') {
                    oneIndexList.add(new Data(i, i));
                }
            }

            for (int i = 1; i < size; i++) {
                int diff = zeroIndexList.get(i) - zeroIndexList.get(i - 1);
                int curZeroIdx = zeroIndexList.get(i);
                // 统计1开始的第i位也是1的oneIndexList
                List<Data> newOneIndexList = new ArrayList<>();
                for (Data data : oneIndexList) {
                    int oneIdx = data.curIdx;
                    int nextOneIdx = oneIdx + diff;
                    if (nextOneIdx > curZeroIdx || nextOneIdx >= len) {
                        break;
                    }
                    if (oneIdxSet.contains(nextOneIdx)) {
                        newOneIndexList.add(new Data(data.originIdx, nextOneIdx));
                    }
                }

                // 如果只剩下一个的话， 那么用这个即可
                // 如果当前没找到，说明用上一次的其中最大的一个
                int newSize = newOneIndexList.size();
                if (newSize == 0) {
                    // 用上次最大的那个
                    String strMax = "0";
                    for (Data data : oneIndexList) {
                        int originIdx = data.originIdx;
                        String tmpStr = getMax(arr1, zeroIndexList, originIdx);
                        if (tmpStr.compareTo(strMax) > 0) {
                            strMax = tmpStr;
                        }
                    }
                    out.println(strMax);
                    break;
                } else if (newSize == 1) {
                    String strMax = getMax(arr1, zeroIndexList, newOneIndexList.get(0).originIdx);
                    out.println(strMax);
                    break;
                } else if (i == size - 1) {
                    String strMax = "0";
                    for (Data data : newOneIndexList) {
                        int originIdx = data.originIdx;
                        String tmpStr = getMax(arr1, zeroIndexList, originIdx);
                        if (tmpStr.compareTo(strMax) > 0) {
                            strMax = tmpStr;
                        }
                    }
                    out.println(strMax);
                }

                oneIndexList = newOneIndexList;
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
