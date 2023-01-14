package contest.contest325;

import java.util.Arrays;

public class B {

    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }

        char[] arr = s.toCharArray();
        int len = arr.length;
        int[][] preCountArr = new int[len][3];
        preCountArr[0][arr[0] - 'a']++;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i] - 'a' == j) {
                    preCountArr[i][j] = preCountArr[i - 1][j] + 1;
                } else {
                    preCountArr[i][j] = preCountArr[i - 1][j];
                }
            }
        }

        int[][] sufCountArr = new int[len][3];
        sufCountArr[len - 1][arr[len - 1] - 'a']++;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (arr[i] - 'a' == j) {
                    sufCountArr[i][j] = sufCountArr[i + 1][j] + 1;
                } else {
                    sufCountArr[i][j] = sufCountArr[i + 1][j];
                }
            }
        }

        // 全取
        int[] countArr = new int[3];
        for (char c : arr) {
            countArr[c - 'a']++;
        }

        for (int i = 0; i < 3; i++) {
            if (countArr[i] < k) {
                return -1;
            }
        }

        int ansMin = len;
        int curR = 1;
        for (int l = 0; l < len - 1; l++) {
            int[] leftCountArr = preCountArr[l];
            boolean isOk1 = true;
            for (int j = 0; j < 3; j++) {
                if (leftCountArr[j] < k) {
                    isOk1 = false;
                    break;
                }
            }
            if (isOk1) {
                ansMin = Math.min(ansMin, l + 1);
                break;
            }
            for (int r = curR; r < len; r++) {
                int[] rightCountArr = sufCountArr[r];
                boolean isOk = true;
                for (int j = 0; j < 3; j++) {
                    if (leftCountArr[j] + rightCountArr[j] < k) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) {
                    ansMin = Math.min(ansMin, l + 1 + len - r);
                    curR = r;
                } else {
                    break;
                }
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            boolean isOk = true;
            for (int j = 0; j < 3; j++) {
                if (sufCountArr[i][j] < k) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                ansMin = Math.min(ansMin, len - i);
                break;
            }
        }

        return ansMin;
    }

    public static void main(String[] args) {
//        "acbcc"
//        1
        System.out.println(new B().takeCharacters("acbcc", 1));
    }

}
