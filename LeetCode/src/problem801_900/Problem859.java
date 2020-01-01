package problem801_900;

import java.util.Arrays;

public class Problem859 {

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public boolean buddyStrings(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int len = arr1.length;

        if (Arrays.equals(arr1, arr2)) {
            // 本身相等，且有两个相同的字符,则说明可替换
            int[] countArr = new int[26];
            for (char c : arr1) {
                countArr[c - 'a']++;
                if (countArr[c - 'a'] > 1) {
                    return true;
                }
            }

            return false;
        }

        for (int i = 0; i < len; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                if (arr1[j] == arr2[i]) {
                    swap(arr1, i, j);
                    return Arrays.equals(arr1, arr2);
                }
            }
        }

        return false;
    }

}
