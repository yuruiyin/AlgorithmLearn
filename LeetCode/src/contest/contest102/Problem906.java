package contest.contest102;

public class Problem906 {

    private boolean isPalindrome(long num) {
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private int recCount;

    private void rec(int i, int len, StringBuilder tmpSb, long max) {
        if (i == len / 2) {
            if (len % 2 == 1) {
                // 奇数个
                for (int j = 0; j <= 9; j++) {
                    StringBuilder oldSb = new StringBuilder(tmpSb.toString());
                    String ansStr = tmpSb + (j + "") + oldSb.reverse();
                    long num = Long.parseLong(ansStr);
                    if (num * num <= max && isPalindrome(num * num)) {
                        recCount++;
                    }
                }
            } else {
                StringBuilder curSb = new StringBuilder(tmpSb.toString());
                String ansStr = tmpSb + curSb.reverse().toString();
                long num = Long.parseLong(ansStr);
                if (num * num <= max && isPalindrome(num * num)) {
                    recCount++;
                }
            }
            return;
        }

        int start = i == 0 ? 1 : 0;
        for (int j = start; j <= 9; j++) {
            tmpSb.append(j);
            rec(i + 1, len, tmpSb, max);
            tmpSb.deleteCharAt(tmpSb.length() - 1);
        }
    }

    /**
     * 求<=num以内的超级回文数
     */
    private int getCount(long num) {
        if (num == 0) {
            return 0;
        }

        int sqrt = (int) Math.sqrt(num);
        int count = String.valueOf(sqrt).length();
        int ansCount = 0;
        // 先单独处理1位的情况
        for (int i = 1; i <= 9; i++) {
            if (i > sqrt) {
                break;
            }
            if (i * i <= num && isPalindrome(i * i)) {
                ansCount++;
            }
        }

        for (int i = 2; i <= count; i++) {
            // 处理一半即可
            recCount = 0;
            rec(0, i, new StringBuilder(), num);
            ansCount += recCount;
        }
        return ansCount;
    }

    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        return getCount(r) - getCount(l - 1);
    }

}
