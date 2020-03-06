package holiday_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private static int[] getDateArr(String date) {
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(date.substring(0, 4));
        arr[1] = Integer.parseInt(date.substring(4, 6));
        arr[2] = Integer.parseInt(date.substring(6, 8));
        return arr;
    }

    private static String getDateStr(int[] arr) {
        StringBuilder sb = new StringBuilder(String.format("%04d", arr[0]));
        sb.append(String.format("%02d", arr[1])).append(String.format("%02d", arr[2]));
        return sb.toString();
    }

    private static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static int[] getNextDay(int[] dateArr) {
        int year = dateArr[0];
        int month = dateArr[1];
        int day = dateArr[2];

        if (month != 2) {
            int monthDay = monthDays[month - 1];
            if (day == monthDay) {
                month++;
                day = 1;
            } else {
                day++;
            }

            if (month > 12) {
                year++;
                month = 1;
            }
        } else {
            int monthDay = 28;
            if (isLeap(year)) {
                monthDay++;
            }

            if (day == monthDay) {
                month++;
                day = 1;
            } else {
                day++;
            }
        }

        return new int[]{year, month, day};
    }

    private static int[] getNextMonth(int[] dateArr) {
        int year = dateArr[0];
        int month = dateArr[1];
        int day = 1;

        month++;

        if (month > 12) {
            year++;
            month = 1;
        }

        return new int[]{year, month, day};
    }

    private static int[] getNextYear(int[] dateArr) {
        return new int[]{dateArr[0] + 1, 1, 1};
    }

    private static boolean isBigger(int[] dateArr1, int[] dateArr2) {
        int date1 = dateArr1[0] * 10000 + dateArr1[1] * 100 + dateArr1[2];
        int date2 = dateArr2[0] * 10000 + dateArr2[1] * 100 + dateArr2[2];
        return date1 > date2;
    }

    private static void solve() throws IOException {
        String date1 = next();
        String date2 = next();

        int[] dateArr1 = getDateArr(date1);
        int[] dateArr2 = getDateArr(date2);

        int count = 0;
        int[] curDateArr = dateArr1;

        while (true) {
            String curDateStr = getDateStr(curDateArr);
            if (isPalindrome(curDateStr)) {
                count++;
            }

            // 去除年的后两位，看是否与月互为回文
            String yearLowTwoBit = String.format("%02d", curDateArr[0] % 100);
            String month = String.format("%02d", curDateArr[1]);

            if (yearLowTwoBit.charAt(1) > '1' || yearLowTwoBit.charAt(1) == '1' && yearLowTwoBit.charAt(0) > '2') {
                // 年+1
                curDateArr = getNextYear(curDateArr);
            } else if (!isPalindrome(yearLowTwoBit + month)) {
                // 月份+1
                curDateArr = getNextMonth(curDateArr);
            } else {
                // day+1
                curDateArr = getNextDay(curDateArr);
            }

            if (isBigger(curDateArr, dateArr2)) {
                break;
            }
        }

        System.out.println(count);
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
