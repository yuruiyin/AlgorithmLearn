package holiday_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static long[] factorialArr;

    private static long factorial(int n) {
        if (n == 0) {
            factorialArr[0] = 1;
            return 1;
        }

        factorialArr[n] = n * factorial(n - 1);
        return factorialArr[n];
    }

    private static List<Integer> rec(List<Integer> list, long idx) {
        if (idx == 1) {
            return list;
        }

        int size = list.size();
        int nextIndex = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (factorialArr[size - i] >= idx) {
                nextIndex = i;
                break;
            }
        }

        List<Integer> ansList = new ArrayList<>();
        if (nextIndex != 0) {
            ansList.addAll(list.subList(0, nextIndex));
        }

        if (factorialArr[size - nextIndex] == idx) {
            List<Integer> nextList = list.subList(nextIndex, list.size());
            Collections.reverse(nextList);
            ansList.addAll(nextList);
        } else {
            long smallerFactorial = factorialArr[size - nextIndex - 1];
            long value = idx / smallerFactorial;
            long mod = idx % smallerFactorial;
            if (mod == 0) {
                int firstNumIndex = (int) (nextIndex + value - 1);
                ansList.add(list.get(firstNumIndex));
                list.remove(firstNumIndex);
                List<Integer> nextList = list.subList(nextIndex, list.size());
                Collections.reverse(nextList);
                ansList.addAll(nextList);
            } else {
                int firstNumIndex = (int) (nextIndex + value);
                ansList.add(list.get(firstNumIndex));
                list.remove(firstNumIndex);
                List<Integer> nextList = list.subList(nextIndex, list.size());
                ansList.addAll(rec(nextList, mod));
            }
        }

        return ansList;
    }

    private static long getFactorialIndex(List<Integer> list) {
        if (list.size() == 1) {
            return 1;
        }

        List<Integer> tmpList = new ArrayList<>(list);
        Collections.sort(tmpList);

        int size = list.size();
        int firstNum = list.get(0);
        int firstNumIndex = 0;
        for (int i = 0; i < size; i++) {
            if (firstNum == tmpList.get(i)) {
                firstNumIndex = i;
                break;
            }
        }

        long afterFactorial = factorialArr[size - 1];
        long ans = 0;
        ans += afterFactorial * firstNumIndex;
        ans += getFactorialIndex(list.subList(1, list.size()));
        return ans;
    }

    private static void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();

        factorialArr = new long[21];
        factorial(n);

        for (int i = 0; i < k; i++) {
            String oper = next();
            if (oper.equals("P")) {
                long idx = nextLong();
                // 列出第num个全排列
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j <= n; j++) {
                    list.add(j);
                }
                List<Integer> ansList = rec(list, idx);
                for (Integer num: ansList) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    list.add(nextInt());
                }

                // 计算该全排列是第几个排列
                System.out.println(getFactorialIndex(list));
            }
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
