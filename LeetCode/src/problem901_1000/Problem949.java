package problem901_1000;

import java.util.Arrays;

public class Problem949 {

    private int[] getOtherIndexs(int index1, int index2) {
        int[] ansArr = new int[2];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            if (i != index1 && i != index2) {
                ansArr[index++] = i;
            }
        }

        return ansArr;
    }

    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int maxHour = -1;
        int maxMinute = -1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                int hour = arr[i] * 10 + arr[j];
                int[] minuteIndexs = getOtherIndexs(i, j);
                int minute1 = arr[minuteIndexs[0]] * 10 + arr[minuteIndexs[1]];
                int minute2 = arr[minuteIndexs[1]] * 10 + arr[minuteIndexs[0]];
                if (hour >= 0 && hour <= 23 && hour > maxHour && (minute1 <= 59 || minute2 <= 59)) {
                    maxHour = hour;
                    if (minute1 <= 59 && minute2 <= 59) {
                        maxMinute = Math.max(minute1, minute2);
                    } else if (minute1 <= 59) {
                        maxMinute = minute1;
                    } else {
                        maxMinute = minute2;
                    }
                }
            }
        }

        if (maxHour == -1) {
            return "";
        }

        return String.format("%02d:%02d", maxHour, maxMinute);

    }

}

//  给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
//
//        最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
//
//        以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
//
//
//
//        示例 1：
//
//        输入：[1,2,3,4]
//        输出："23:41"
//        示例 2：
//
//        输入：[5,5,5,5]
//        输出：""
//
//
//        提示：
//
//        A.length == 4
//        0 <= A[i] <= 9
