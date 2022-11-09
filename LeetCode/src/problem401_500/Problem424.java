package problem401_500;

public class Problem424 {

    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[][] preCountArr = new int[len][26];
        preCountArr[0][arr[0] - 'A']++;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                if (arr[i] - 'A' == j) {
                    preCountArr[i][j] = preCountArr[i - 1][j] + 1;
                } else {
                    preCountArr[i][j] = preCountArr[i - 1][j];
                }
            }
        }

        int ansMax = 1;
        for (int j = 0; j < 26; j++) {
            int l = 0;
            for (int r = 0; r < len; r++) {
                // 以r未结尾
                int lPreCount = l == 0 ? 0 : preCountArr[l - 1][j];
                int preCount = preCountArr[r][j];
                while (r - l + 1 - (preCount - lPreCount) > k) {
                    l++;
                }
                ansMax = Math.max(ansMax, r - l + 1);
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new Problem424().characterReplacement("AABABBA", 1));
    }

}
