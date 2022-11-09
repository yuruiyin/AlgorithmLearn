package interview_google.round11;

import kotlin.jvm.functions.Function1;

public class C {

    private long getReverseNum(long num) {
        long reverseNum = 0;
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }
        return reverseNum;
    }

    private long getPalindrome(long half, int midValue) {
        if (half == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(half + "");
        if (midValue == -1) {
            return Long.parseLong(half + "" + sb.reverse());
        }
        return Long.parseLong(half + "" + midValue + sb.reverse());
    }

    private long[] getAns(long num, int midNum) {
        // 二分
        long l = 0;
        long r = (int) 1e9;
        long ansMinDiff = Long.MAX_VALUE;
        long ansMinValue = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long value = getPalindrome(mid, midNum);
            if (value < num) {
                if (getPalindrome(mid + 1, midNum) >= num) {
                    ansMinDiff = num - value;
                    ansMinValue = value;
                    break;
                } else {
                    l = mid + 1;
                }
            } else if (value == num) {
                // 左减一，右加一，比大小
                long leftValue = getPalindrome(mid - 1, midNum);
                long rightValue = getPalindrome(mid + 1, midNum);
                if (num - leftValue <= rightValue - num) {
                    ansMinDiff = num - leftValue;
                    ansMinValue = leftValue;
                } else {
                    ansMinDiff = rightValue - num;
                    ansMinValue = rightValue;
                }
                break;
            } else {
                r = mid - 1;
            }
        }

        l = 0;
        r = (int) 1e9;
        long ansMinDiff1 = Long.MAX_VALUE;
        long ansMinValue1 = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            long value = getPalindrome(mid, midNum);
            if (value > num) {
                if (getPalindrome(mid - 1, midNum) <= num) {
                    ansMinDiff1 = value - num;
                    ansMinValue1 = value;
                    break;
                } else {
                    r = mid - 1;
                }
            } else if (value == num) {
                // 左减一，右加一，比大小
                long leftValue = getPalindrome(mid - 1, midNum);
                long rightValue = getPalindrome(mid + 1, midNum);
                if (num - leftValue <= rightValue - num) {
                    ansMinDiff1 = num - leftValue;
                    ansMinValue1 = leftValue;
                } else {
                    ansMinDiff1 = rightValue - num;
                    ansMinValue1 = rightValue;
                }
                break;
            } else {
                l = mid + 1;
            }
        }

        if (ansMinDiff <= ansMinDiff1) {
            return new long[]{ansMinDiff, ansMinValue};
        }
        return new long[]{ansMinDiff1, ansMinValue1};
    }

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long[] res1 = getAns(num, -1);
        long[] res2 = new long[]{Long.MAX_VALUE, Long.MAX_VALUE};
        for (int i = 0; i <= 9; i++) {
            long[] tmpRes = getAns(num, i);
            if (tmpRes[0] <= res2[0]) {
                if (tmpRes[0] == res2[0]) {
                    if (tmpRes[1] <= res2[1]) {
                        res2 = tmpRes;
                    }
                } else {
                    res2 = tmpRes;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            if (i == num) {
                continue;
            }
            long diff = Math.abs(num - i);
            if (diff <= res2[0]) {
                if (diff == res2[0]) {
                    if (i <= res2[1]) {
                        res2 = new long[]{diff, i};
                    }
                } else {
                    res2 = new long[]{diff, i};
                }
            }
        }

        long ansMinValue1 = res1[1];
        long ansMinValue2 = res2[1];

        long abs1 = Math.abs(ansMinValue1 - num);
        long abs2 = Math.abs(ansMinValue2 - num);
        if (abs1 == abs2) {
            return String.valueOf(Math.min(ansMinValue1, ansMinValue2));
        } else if (abs1 < abs2) {
            return String.valueOf(ansMinValue1);
        }
        return String.valueOf(ansMinValue2);
    }

    public static void main(String[] args) {
        System.out.println(new C().nearestPalindromic("123"));
    }

}
