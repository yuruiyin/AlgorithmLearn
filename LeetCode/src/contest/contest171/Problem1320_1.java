package contest.contest171;

public class Problem1320_1 {

    private char[] arr;
    private int len;
    private Integer[][] memo;

    private int getDis(int index1, int index2) {
        int i1 = index1 / 6;
        int j1 = index1 % 6;
        int i2 = index2 / 6;
        int j2 = index2 % 6;
        return Math.abs(i1 - i2) + Math.abs(j1 - j2);
    }

    private int backTrack(int wordIndex1, int index2) {
        if (wordIndex1 == len - 1) {
            return 0;
        }

        if (memo[wordIndex1+1][index2] != null) {
            return memo[wordIndex1 + 1][index2];
        }

        int nextCharIndex = arr[wordIndex1 + 1] - 'A';
        int index1 = arr[wordIndex1] - 'A';
        int firstMoveRes = backTrack(wordIndex1 + 1, index2) + getDis(index1, nextCharIndex);
        int secondMoveRes = backTrack(wordIndex1 + 1, index1) + getDis(index2, nextCharIndex);

        memo[wordIndex1 + 1][index2] = Math.min(firstMoveRes, secondMoveRes);
        return memo[wordIndex1 + 1][index2];
    }

    public int minimumDistance(String word) {
        arr = word.toCharArray();
        len = arr.length;

        int min = Integer.MAX_VALUE;
        memo = new Integer[len+1][26];
        boolean[] indexExisted = new boolean[26];
        for (char c : arr) {
            indexExisted[c - 'A'] = true;
        }

        for (int secondIndex = 0; secondIndex < 26; secondIndex++) {
            int firstIndex = arr[0] - 'A';
            if (secondIndex == firstIndex || !indexExisted[secondIndex]){
                continue;
            }
            min = Math.min(min, backTrack(0, secondIndex));
        }

        return min;
    }

}
