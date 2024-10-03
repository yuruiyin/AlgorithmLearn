package doubleContest.round138;

import java.util.*;

public class C {

    private int getNumBitCount(long num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    private long getReverseNum(long num) {
        long ans = 0;
        while (num > 0) {
            ans = ans * 10 + (num % 10);
            num /= 10;
        }
        return ans;
    }

    private long getPalindrome(long left, int mid) {
        int leftBitCount = getNumBitCount(left);
        long right = getReverseNum(left);
        return (long) (left * Math.pow(10, leftBitCount + 1) + mid * Math.pow(10, leftBitCount) + right);
    }

    private long getPalindrome(long left) {
        int leftBitCount = getNumBitCount(left);
        long right = getReverseNum(left);
        return (long) (left * Math.pow(10, leftBitCount) + right);
    }

    private long getCount(long palin, int k) {
        // 求palin不含前导0的排列数
        int bitCount = getNumBitCount(palin);
        int[] countArr = new int[10];
        while (palin > 0) {
            int mod = (int) (palin % 10);
            countArr[mod]++;
            palin /= 10;
        }

        List<Integer> sameCountList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (countArr[i] > 1) {
                sameCountList.add(countArr[i]);
            }
        }

        long ans = 1;
        // n阶乘
        long njc = 1;
        for (int i = 2; i <= bitCount; i++) {
            njc *= i;
        }

        ans = njc;

        // 需要除以相同的
        for (int sameCount : sameCountList) {
            for (int i = 2; i <= sameCount; i++) {
                ans /= i;
            }
        }

        // 需要减去前导0，如果有0，则拿出一个0放到第一位，然后求剩下的排列数
        if (countArr[0] > 0) {
            long count = njc / bitCount;
            countArr[0]--;
            List<Integer> sameCountList1 = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                if (countArr[i] > 1) {
                    sameCountList1.add(countArr[i]);
                }
            }

            for (int sameCount : sameCountList1) {
                for (int i = 2; i <= sameCount; i++) {
                    count /= i;
                }
            }

            ans -= count;
        }

        return ans;
    }

    private String getSortStr(long num) {
        int bitCount = getNumBitCount(num);
        char[] arr = new char[bitCount];
        int idx = 0;
        while (num > 0) {
            arr[idx++] = (char) (num % 10 + '0');
            num /= 10;
        }
        Arrays.sort(arr);
        return new String(arr);
    }

    public long countGoodIntegers(int n, int k) {
        // 枚举所有回文数
        int eachCount = n / 2;
        if (eachCount == 0) {
            // 说明n = 1
            return 9 / k;
        }

        int midCount = n % 2;

        // 1...x
        int from = (int) Math.pow(10, eachCount - 1);
        int to = (int) Math.pow(10, eachCount) - 1;
        long ans = 0;
        Set<String> oddVisited = new HashSet<>();
        Set<String> evenVisited = new HashSet<>();
        for (int left = from; left <= to; left++) {
            if (midCount == 1) {
                for (int mid = 0; mid <= 9; mid++) {
                    long palin = getPalindrome(left, mid);
                    if (palin % k != 0) {
                        continue;
                    }
                    String key = getNumBitCount(palin) + "," + getSortStr(palin);
                    if (oddVisited.contains(key)) {
                        continue;
                    }
                    oddVisited.add(key);
                    ans += getCount(palin, k);
                }
            } else {
                long palin = getPalindrome(left);
                if (palin % k != 0) {
                    continue;
                }
                String key = getNumBitCount(palin) + "," + getSortStr(palin);
                if (evenVisited.contains(key)) {
                    continue;
                }
                evenVisited.add(key);
                ans += getCount(palin, k);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
