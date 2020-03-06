package holiday_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class E {

    private static final long MOD = 12345678910L;

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int n = nextInt();
        Stack<Long> stack = new Stack<>(); // -1代表'('

        for (int i = 0; i < n; i++) {
            int num = nextInt();
            if (num == 1) {
                // ')'
                if (stack.isEmpty()) {
                    continue;
                }

                long top = stack.peek();
                if (top == -1) {
                    stack.pop();
                    // 将栈顶的连续多个数字相加
                    long sum = 1;
                    while (!stack.isEmpty() && stack.peek() != -1) {
                        sum = sum + stack.pop();
                    }

                    stack.push(sum % MOD);
                } else {
                    // 栈顶是数字,需要乘以2
                    long topNum = stack.pop();
                    stack.pop();
                    long sum = topNum * 2;
                    while (!stack.isEmpty() && stack.peek() != -1) {
                        sum = sum + stack.pop();
                    }

                    stack.push(sum % MOD) ;
                }
            } else {
                stack.push(-1L);
            }
        }

        long ans = 0;
        while (!stack.isEmpty()) {
            long top = stack.pop();
            if (top == -1) {
                continue;
            }

            ans = (ans + top) % MOD;
        }
        System.out.println(ans);
    }

    private static void makeArr() {
        int n = 256;
        int[] ansArr = new int[n];
        for (int i = n / 2; i < n; i++) {
            ansArr[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ansArr[i]);
        }
    }
    

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
//        makeArr();
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
