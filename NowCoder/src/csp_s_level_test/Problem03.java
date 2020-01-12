package csp_s_level_test;

import java.util.Scanner;

public class Problem03 {

    public static class Main {
        private static final int MOD = (int) (1e9 + 7);

        // 获取2的n次方
        private int getExp(int n) {
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                ans = (ans << 1L) % MOD;
            }
            return (int) ans;
        }

        private void solve() {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.next();
            }

            int qCount = 0; //问号个数
            StringBuilder sb = new StringBuilder();
            for (String str : arr) {
                for (char c : str.toCharArray()) {
                    if (c == '?') {
                        qCount++;
                    }
                }
                sb.append(str);
            }

            char[] mergeArr = sb.toString().toCharArray();
            int charCount = mergeArr.length;
            // b只能从1开始
            int minQCount = 3;
            for (int b = 1; 2*b < charCount; b++) {
                for (int a = 0; a + 2 * b < charCount; a++) {
                    if (mergeArr[a] == 'O' || mergeArr[a+b] == 'I' || mergeArr[a+2*b] == 'O') {
                        continue;
                    }

                    int tmpQCount = 0;
                    if (mergeArr[a] == '?') {
                        tmpQCount++;
                    }

                    if (mergeArr[a+b] == '?') {
                        tmpQCount++;
                    }

                    if (mergeArr[a+2*b] == '?') {
                        tmpQCount++;
                    }

                    minQCount = Math.min(minQCount, tmpQCount);
                }
            }

            int minQCountCount = 0;
            for (int b = 1; 2*b < charCount; b++) {
                for (int a = 0; a + 2 * b < charCount; a++) {
                    if (mergeArr[a] == 'O' || mergeArr[a+b] == 'I' || mergeArr[a+2*b] == 'O') {
                        continue;
                    }

                    int tmpQCount = 0;
                    if (mergeArr[a] == '?') {
                        tmpQCount++;
                    }

                    if (mergeArr[a+b] == '?') {
                        tmpQCount++;
                    }

                    if (mergeArr[a+2*b] == '?') {
                        tmpQCount++;
                    }

                    if (tmpQCount == minQCount) {
                        minQCountCount++;
                    }
                }
            }

            long ans = 0;
            for (int i = 0; i < minQCountCount; i++) {
                ans = (ans + getExp(qCount - minQCount)) % MOD;
            }

            System.out.println(ans);
        }

        public static void main(String[] args) {
            new Main().solve();
        }
    }

}
