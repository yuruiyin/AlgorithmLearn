package doubleContest.round32;

import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/8
 */
public class D {

    public int longestAwesome(String s) {
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = charArr[i] - '0';
        }

        int pre = 1;
        int ansMax = pre;
        int midIdx = 0;
        for (int end = 1; end < len; end++) {
            if (pre % 2 == 1) {
                if (arr[end] == arr[midIdx]) {
                    if (pre == end) {
                        pre++;
                    } else {
                        pre += 2;
                        midIdx = end - pre - 1;
                    }
                } else {
                    if (pre != end && arr[end] == arr[end - pre - 1]) {
                        pre += 2;
                    } else {
                        int j;
                        for (j = end - pre; j < end; j++) {
                            if (arr[j] == arr[midIdx]) {
                                break;
                            }
                        }



                    }
                }
            } else {
                pre++;
                midIdx = end;
            }

            ansMax = Math.max(ansMax, pre);
        }

        return ansMax;
    }

}
