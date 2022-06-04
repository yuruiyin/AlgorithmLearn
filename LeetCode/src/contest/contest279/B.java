package contest.contest279;

import java.util.Arrays;

public class B {


    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        } else if (num < 0) {
            char[] arr = String.valueOf(Math.abs(num)).toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                sb.append(arr[i]);
            }
            return -Long.parseLong(sb.toString());
        } else {
            char[] arr = String.valueOf(num).toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            char minNum = '9';
            int minNumIdx = -1;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] != '0') {
                    if (arr[i] <= minNum) {
                        minNum = arr[i];
                        minNumIdx = i;
                    }
                }
            }

            sb.append(minNum);
            for (int i = 0; i < arr.length; i++) {
                if (i == minNumIdx) {
                    continue;
                }
                sb.append(arr[i]);
            }

            return Long.parseLong(sb.toString());
        }
    }

}
