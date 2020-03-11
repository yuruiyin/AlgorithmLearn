package holiday_33;

import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    static class Task {

        class Data {
            int index;
            int val;
            Data(int index, int val) {
                this.index = index;
                this.val = val;
            }
        }

        private int findFirstBigger(Data[] datas, int from, int target) {
            int size = datas.length;
            int low = from;
            int high = size - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = datas[mid].val;
                if (midVal > target) {
                    if (mid == from || datas[mid - 1].val <= target) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            Data[] datas = new Data[m];
            for (int i = 0; i < m; i++) {
                datas[i] = new Data(i, in.nextInt());
            }

            Arrays.sort(datas, Comparator.comparingDouble(o -> o.val));

            long[][] ansCountArr = new long[m][4];
            List<Integer>[] indexListArr = new ArrayList[n + 1];

            for (int i = 0; i < m; i++) {
                int val = datas[i].val;
                if (indexListArr[val] == null) {
                    indexListArr[val] = new ArrayList<>();
                }
                indexListArr[val].add(datas[i].index);
            }

            List<Data> dataList = new ArrayList<>();
            dataList.add(datas[0]);
            for (int i = 1; i < m; i++) {
                if (datas[i].val == datas[i-1].val) {
                    continue;
                }

                dataList.add(datas[i]);
            }

            int size = dataList.size();
            Data[] newDatas = new Data[size];
            dataList.toArray(newDatas);

            for (int i = 0; i < size - 3; i++) {
                int a = newDatas[i].val;

                for (int j = i + 1; j < size - 2; j++) {
                    int b = newDatas[j].val;
                    // b - a 必须是偶数
                    if ((b - a) % 2 == 1) {
                        continue;
                    }

                    if (2 * (newDatas[size - 1].val - newDatas[j + 1].val) < b - a) {
                        break;
                    }

                    int nextCIndex = findFirstBigger(newDatas, j + 1, 4 * b - 3 * a);
                    if (nextCIndex == -1 || nextCIndex == size - 1) {
                        break;
                    }

                    for (int k = nextCIndex; k < size - 1; k++) {
                        int c = newDatas[k].val;
                        // 找d, 使用indexListArr
                        int wantD = (b - a) / 2 + c;
                        if (wantD > newDatas[size - 1].val) {
                            break;
                        }

                        if (indexListArr[wantD] == null) {
                            continue;
                        }

                        long aCount = indexListArr[a].size();
                        long bCount = indexListArr[b].size();
                        long cCount = indexListArr[c].size();
                        long dCount = indexListArr[wantD].size();

                        for (Integer aIndex : indexListArr[a]) {
                            ansCountArr[aIndex][0] += bCount * cCount * dCount;
                        }

                        for (Integer bIndex : indexListArr[b]) {
                            ansCountArr[bIndex][1] += aCount * cCount * dCount;
                        }

                        for (Integer cIndex : indexListArr[c]) {
                            ansCountArr[cIndex][2] += aCount * bCount * dCount;
                        }

                        for (Integer dIndex : indexListArr[wantD]) {
                            ansCountArr[dIndex][3] += aCount * bCount * cCount;
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 4; j++) {
                    out.print(ansCountArr[i][j] + " ");
                }
                out.println();
            }

        }
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
