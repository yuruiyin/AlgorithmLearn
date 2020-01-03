package problem801_900;

import java.util.Arrays;

public class Problem893 {

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private boolean isSpecialEqual(String str1, String str2) {
        int len = str1.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }

        for (int i = 0; i < len; i+=2) {
            if (arr1[i] == arr2[i]) {
                continue;
            }

            for (int j = i + 2; j < len; j += 2) {
                if (arr1[j] == arr2[i]) {
                    swap(arr1, i, j);
                    break;
                }
            }

            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }

        if (Arrays.equals(arr1, arr2)) {
            return true;
        }

        for (int i = 1; i < len; i+=2) {
            if (arr1[i] == arr2[i]) {
                continue;
            }

            for (int j = i + 2; j < len; j += 2) {
                if (arr1[j] == arr2[i]) {
                    swap(arr1, i, j);
                    break;
                }
            }

            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }

        return Arrays.equals(arr1, arr2);
    }

    public int numSpecialEquivGroups(String[] arr) {
        int len = arr.length;
        boolean[] visited = new boolean[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            ans++;
            for (int j = i + 1; j < len; j++) {
                if (isSpecialEqual(arr[i], arr[j])) {
                    visited[j] = true;
                }
            }
        }

        return ans;
    }

}
