package contest.contest268;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/21
 */
public class D {

    /**
     * 求一个数的k进制
     */
    private char[] getK(int k, long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString().toCharArray();
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void getList(int cur, int n, long tmpNum, List<Long> list) {
        if (cur == n / 2) {
            if (n % 2 == 1) {
                for (int i = 0; i <= 9; i++) {
                    long tmpNum1 = tmpNum;
                    tmpNum1 += Math.pow(10, (int) (n / 2)) * i;
                    list.add(tmpNum1);
                }
            } else {
                list.add(tmpNum);
            }
            return;
        }

        int from = 0;
        if (cur == 0) {
            from = 1;
        }
        for (int i = from; i <= 9; i++) {
            tmpNum += Math.pow(10, cur) * i;
            tmpNum += Math.pow(10, n - cur - 1) * i;
            getList(cur + 1, n, tmpNum, list);
            tmpNum -= Math.pow(10, cur) * i;
            tmpNum -= Math.pow(10, n - cur - 1) * i;
        }
    }

    public long kMirror(int k, int n) {
        long ans = 0;
        List<Long> list = new ArrayList<>();
        for (int bit = 1; bit <= 14; bit++) {
            if (list.size() >= n) {
                break;
            }

            List<Long> tmpList = new ArrayList<>();
            if (bit == 1) {
                for (int i = 1; i <= 9; i++) {
                    tmpList.add((long) i);
                }
            } else {
                getList(0, bit, 0, tmpList);
            }

            for (long num : tmpList) {
                char[] arrK = getK(k, num);
                if (isPalindrome(arrK, 0, arrK.length - 1)) {
                    list.add(num);
                }
            }
        }

        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            ans += list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new D().kMirror(3, 7));
        for (int k = 2; k <= 9; k++) {
            System.out.println(new D().kMirror(k, 30));
//            System.out.println(new D().kMirror(k, 5));
        }
    }

}
