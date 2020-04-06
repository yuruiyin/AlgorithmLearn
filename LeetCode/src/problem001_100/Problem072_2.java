package problem001_100;

/**
 * Problem072_2
 *
 * @author: yry
 * @date: 2020/4/6
 */
public class Problem072_2 {

    // 一维dp版本
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0) {
            return len2;
        }

        if (len2 == 0) {
            return len1;
        }

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[] prevRowDp = new int[len2];
        int[] curRowDp = new int[len2];

        prevRowDp[0] = arr1[0] == arr2[0] ? 0 : 1;
        for (int j = 1; j < len2; j++) {
            prevRowDp[j] = arr1[0] == arr2[j] ? j : prevRowDp[j - 1] + 1;
        }

        for (int i = 1; i < len1; i++) {
            curRowDp[0] = arr1[i] == arr2[0] ? i : prevRowDp[0] + 1;
            for (int j = 1; j < len2; j++) {
                // 左、上、左上三者取最小
                if (arr1[i] == arr2[j]) {
                    curRowDp[j] = Math.min(prevRowDp[j - 1], Math.min(curRowDp[j - 1] + 1, prevRowDp[j] + 1));
                } else {
                    curRowDp[j] = Math.min(prevRowDp[j - 1] + 1, Math.min(curRowDp[j - 1] + 1, prevRowDp[j] + 1));
                }
            }

            int[] tmp = prevRowDp;
            prevRowDp = curRowDp;
            curRowDp = tmp;
        }

        return prevRowDp[len2 - 1];
    }

}
