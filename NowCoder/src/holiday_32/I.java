package holiday_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class I {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    static class Data {
        int time;
        Map<Integer, Integer> countMap;
        Data(int time, Map<Integer, Integer> countMap) {
            this.time = time;
            this.countMap = countMap;
        }
    }

    private static void mergeCount(Map<Integer, Integer> gCountMap, Map<Integer, Integer> countMap) {
        for (Integer country : countMap.keySet()) {
            gCountMap.put(country, gCountMap.getOrDefault(country, 0) + countMap.get(country));
        }
    }

    private static void removeCount(Map<Integer, Integer> gCountMap, Map<Integer, Integer> countMap) {
        for (Integer country : countMap.keySet()) {
            gCountMap.put(country, gCountMap.get(country) - countMap.get(country));
            if (gCountMap.get(country) == 0) {
                gCountMap.remove(country);
            }
        }
    }

    private static void solve() throws IOException {
        int n = nextInt();
        LinkedList<Data> queue = new LinkedList<>();
        Map<Integer, Integer> gCountMap = new HashMap<>();
        int[] ansArr = new int[n];
        for (int i = 0; i < n; i++) {
            int time = nextInt();
            int k = nextInt();
            Map<Integer, Integer> countMap = new HashMap<>();
            Data data = new Data(time, countMap);
            while ((k--) > 0) {
                int country = nextInt();
                data.countMap.put(country, data.countMap.getOrDefault(country, 0) + 1);
            }

            queue.offer(data);
            mergeCount(gCountMap, countMap);

            // 删除24小时以外的乘客
            while (!queue.isEmpty()) {
                Data old = queue.peek();
                if (old.time <= time - 86400) {
                    queue.poll();
                    removeCount(gCountMap, old.countMap);
                } else {
                    break;
                }
            }

            ansArr[i] = gCountMap.keySet().size();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ansArr[i]);
        }
    }


    

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
