package contest.contest228;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/14
 */
public class A {

    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        char[] tmpArr = Arrays.copyOf(arr, arr.length);
        int ans1 = 0;
        if (arr[0] == '1') {
            ans1++;
            arr[0] = '0';
        }

        for(int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                ans1++;
                arr[i] = arr[i] == '0' ? '1' : '0';
            }
        }

        int ans2 = 0;
        arr = Arrays.copyOf(tmpArr, tmpArr.length);
        if (arr[0] == '0') {
            ans2++;
            arr[0] = '1';
        }

        for(int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                ans2++;
                arr[i] = arr[i] == '0' ? '1' : '0';
            }
        }

        return Math.min(ans1, ans2);
    }

}
