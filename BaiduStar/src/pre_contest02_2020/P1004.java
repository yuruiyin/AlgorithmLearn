package pre_contest02_2020;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1004 {

    static class Task {

        private List<List<Integer>> ansList;
        private List<Integer>[] listArr;
        private Boolean[][] memo;

        // 求限制车尾号
        private void dfs(int cur, List<Integer> tmpList, int isStopFlag) {
            if (cur == 10) {
                ansList.add(new ArrayList<>(tmpList));
                return;
            }

            if ((isStopFlag & (1 << cur)) != 0) {
                dfs(cur + 1, tmpList, isStopFlag);
            } else {
                tmpList.add(cur);
                dfs(cur + 1, tmpList, isStopFlag);
                tmpList.remove(tmpList.size() - 1);
                dfs(cur + 1, tmpList, isStopFlag);
            }
        }

        private boolean isOkRec(int day, int m, int isStopFlag) {
            if (day == 6) {
                return true;
            }

            if (memo[day][isStopFlag] != null) {
                return memo[day][isStopFlag];
            }

            ansList = new ArrayList<>();
            dfs(0, new ArrayList<>(), isStopFlag);
            for (List<Integer> stopList : ansList) {
                int count = 0;
                boolean[] tmpIsStopArr = new boolean[10];
                for (Integer num : stopList) {
                    tmpIsStopArr[num] = true;
                }

                for (int i = 0; i <= 9; i++) {
                    if (!tmpIsStopArr[i] && listArr[i] != null) {
                        count += listArr[i].size();
                    }
                }

                if (count <= m) {
                    int nextIsStopFlag = 0;
                    for (int i = 0; i <= 9; i++) {
                        if ((isStopFlag & (1 << i)) != 0 || tmpIsStopArr[i]) {
                            nextIsStopFlag |= (1 << i);
                        }
                    }
                    boolean nextRes = isOkRec(day + 1, m, nextIsStopFlag);
                    if (nextRes) {
                        memo[day][isStopFlag] = true;
                        return true;
                    }
                }
            }

            memo[day][isStopFlag] = false;
            return false;
        }

        private boolean isOk(int m) {
            memo = new Boolean[6][1024];
            return isOkRec(1, m, 0);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                listArr = new ArrayList[10];
                for (int i = 0; i < n; i++) {
                    String str = in.next();
                    int lastNum = str.charAt(4) - '0';
                    if (listArr[lastNum] == null) {
                        listArr[lastNum] = new ArrayList<>();
                    }

                    listArr[lastNum].add(i);
                }

                // 二分猜答案
                int low = 0;
                int high = n;
                int ans = n;
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    if (isOk(mid)) {
                        ans = Math.min(ans, mid);
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }

                out.println(ans);
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
