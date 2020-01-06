package hello_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    static class Data {
        boolean isOk;
        int min;
        int max;
        Data(boolean isOk, int min, int max) {
            this.isOk = isOk;
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        Data[] datas = new Data[n];
        for (int i = 0; i < n; i++) {
            int len = nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = nextInt();
            }

            boolean isOk = false;
            for (int j = 0; j < len; j++) {
                int num = arr[j];
                min = Math.min(min, num);
                max = Math.max(max, num);
                if (j > 0 && arr[j] > arr[j-1]) {
                    isOk = true;
                }
            }

            datas[i] = new Data(isOk, min, max);
        }

        long ans = 0;
        List<Integer> minList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (datas[i].isOk) {
                continue;
            }

            minList.add(datas[i].min);
            maxList.add(datas[i].max);
        }

        Collections.sort(minList);
        Collections.sort(maxList);

        int okCount = 0;
        long tmpSum = 0;
        for (int i = 0; i < n; i++) {
            if (datas[i].isOk) {
                ans += 2 * n - 1;
                okCount++;
                ans -= 2 * (okCount - 1);
            } else {
//                if (datas[i].min != datas[i].max) {
//                    ans--;
//                }

                int lastSmallerIndex = findSmaller(minList, datas[i].max);
                if (lastSmallerIndex != -1) {
                    tmpSum += lastSmallerIndex + 1;
                }

                int firstBiggerIndex = findBigger(maxList, datas[i].min);
                if (firstBiggerIndex != -1) {
                    tmpSum += maxList.size() - firstBiggerIndex;
                }

            }
        }
        
        System.out.println(ans + tmpSum / 2);
    }

    private static int findBigger(List<Integer> maxList, int target) {
        int size = maxList.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low +high) >>> 1;
            int midVal = maxList.get(mid);
            if (midVal > target) {
                if (mid == 0 || maxList.get(mid - 1) <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int findSmaller(List<Integer> minList, int target) {
        int size = minList.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low +high) >>> 1;
            int midVal = minList.get(mid);
            if (midVal < target) {
                if (mid == size - 1 || minList.get(mid + 1) >= target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
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
