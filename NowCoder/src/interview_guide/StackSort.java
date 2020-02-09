package interview_guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 用一个栈实现另一个栈的排序
 * https://www.nowcoder.com/questionTerminal/ff8cba64e7894c5582deafa54cca8ff2
 */
public class StackSort {


    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void sortStackBySort(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!helpStack.isEmpty() && helpStack.peek() < cur) {
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }

        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }

    private static void solve() throws IOException {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

        sortStackBySort(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
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
