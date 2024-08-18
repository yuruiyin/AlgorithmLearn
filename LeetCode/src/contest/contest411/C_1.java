package contest.contest411;

public class C_1 {

    private boolean canDiv7(int repeat9Count, int mid, int midCount) {
        int remainder = 0;
        for (int i = 0; i < repeat9Count; i++) {
            remainder = (remainder * 10 + 9) % 7;
        }

        for (int i = 0; i < midCount; i++) {
            remainder = (remainder * 10 + mid) % 7;
        }

        for (int i = 0; i < repeat9Count; i++) {
            remainder = (remainder * 10 + 9) % 7;
        }

        return remainder == 0;
    }

    //    被 1 整除：任何整数都能被 1 整除。
//    被 2 整除：这个数必须是偶数，即个位数字是 0、2、4、6、8。
//    被 3 整除：这个数的各位数字之和必须是 3 的倍数。
//    被 4 整除：这个数的最后两位数字组成的数必须是 4 的倍数。
//    被 5 整除：这个数的个位数必须是 0 或 5。
//    被 6 整除：这个数必须是 2 和 3 的倍数（既是偶数，且各位数字之和是 3 的倍数）。
//    被 7 整除：通常没有简单的特定规则，但你可以通过长除法或试验得知。
//    被 8 整除：这个数的最后三位数字组成的数必须是 8 的倍数。
//    被 9 整除：这个数的各位数字之和必须是 9 的倍数。
    public String largestPalindrome(int n, int k) {
        if (k == 1 || k == 3 || k == 9) {
            return "9".repeat(n);
        }

        if (k == 2) {
            // 偶数即可
            if (n == 1) {
                return "8";
            }
            return "8" + "9".repeat(n - 2) + "8";
        }

        if (k == 4) {
            if (n <= 3) {
                return "8".repeat(n);
            }

            return "88" + "9".repeat(n - 4) + "88";
        }

        if (k == 5) {
            if (n <= 2) {
                return "5".repeat(n);
            }

            return "5" + "9".repeat(n - 2) + "5";
        }

        if (k == 6) {
            if (n == 1) {
                return "6";
            }

            if (n == 2) {
                return "66";
            }

            if (n % 2 == 1) {
                // 中间是一个8
                String repeat9 = "9".repeat((n - 2) / 2);
                return "8" + repeat9 + "8" + repeat9 + "8";
            } else {
                // 中间两个7
                String repeat9 = "9".repeat((n - 4) / 2);
                return "8" + repeat9 + "77" + repeat9 + "8";
            }
        }

        if (k == 7) {
            if (n <= 2) {
                return "7".repeat(n);
            }

            if (n % 2 == 1) {
                // 奇数
                for (int i = 9; i >= 0; i--) {
                    if (canDiv7(n / 2, i, 1)) {
                        String leftRight = "9".repeat(n / 2);
                        return leftRight + i + leftRight;
                    }
                }
            } else {
                for (int i = 9; i >= 0; i--) {
                    if (canDiv7((n - 2) / 2, i, 2)) {
                        String leftRight = "9".repeat((n - 2) / 2);
                        return leftRight + i + i + leftRight;
                    }
                }
            }
        }

        if (k == 8) {
            if (n <= 6) {
                return "8".repeat(n);
            }

            return "888" + "9".repeat(n - 6)  + "888";
        }

        return "Error";
    }

}
