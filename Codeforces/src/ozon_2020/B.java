package ozon_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        String str = next();

        char[] arr = str.toCharArray();
        int len = arr.length;
        List<Integer> rIndexList = new ArrayList<>();
        List<Integer> lIndexList = new ArrayList<>();

        // 双指针
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && arr[left] == ')') {
                left++;
            }

            if (left == right) {
                break;
            }

            lIndexList.add(left);
            while (left < right && arr[right] == '(') {
                right--;
            }

            if (left == right) {
                break;
            }

            rIndexList.add(right);

            left++;
            right--;
        }

        int rCount = rIndexList.size();
        if (rCount == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(1);
        System.out.println(rCount * 2);

        for (int i = 0; i < rCount; i++) {
            System.out.print((lIndexList.get(i) + 1) + " ");
        }

        Collections.reverse(rIndexList);
        for (int i = 0; i < rCount; i++) {
            System.out.print((rIndexList.get(i) + 1) + " ");
        }

        System.out.println();
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
