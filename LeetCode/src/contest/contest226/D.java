package contest.contest226;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/31
 */
public class D {

    private boolean isPalindrome(char[] arr, int l, int r) {
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean checkPartitioning(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        List<Integer> leftIndexList = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (isPalindrome(arr, 0, i)) {
                leftIndexList.add(i);
            }
        }

        List<Integer> rightIndexList = new ArrayList<>();
        for (int i = len - 1; i >= 2; i--) {
            if (isPalindrome(arr, i, len - 1)) {
                rightIndexList.add(i);
            }
        }

        for (int left : leftIndexList) {
            for (int right : rightIndexList) {
                if (left >= right) {
                    continue;
                }

                if (isPalindrome(arr, left + 1, right - 1)) {
                    return true;
                }
            }
        }

        return false;
    }

}
