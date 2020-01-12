package contest.contest171;

public class Problem04 {

    private char[] arr;
    private int len;
    private int[][][] memo;

    private int getDis(int index1, int index2) {
        int i1 = index1 / 6;
        int j1 = index1 % 6;
        int i2 = index2 / 6;
        int j2 = index2 % 6;
        return Math.abs(i1 - i2) + Math.abs(j1 - j2);
    }

    private int backTrack(int from, int firstIndex, int secondIndex) {
        if (from == len) {
            return 0;
        }

        if (memo[from][firstIndex][secondIndex] != -1) {
            return memo[from][firstIndex][secondIndex];
        }

        int curCharIndex = arr[from] - 'A';
        int firstMoveRes = backTrack(from + 1, curCharIndex, secondIndex) + getDis(firstIndex, curCharIndex);
        int secondMoveRes = backTrack(from + 1, firstIndex, curCharIndex) + getDis(secondIndex, curCharIndex);

        memo[from][firstIndex][secondIndex] = Math.min(firstMoveRes, secondMoveRes);

        return memo[from][firstIndex][secondIndex];
    }

    public int minimumDistance(String word) {
        arr = word.toCharArray();
        len = arr.length;

        int min = Integer.MAX_VALUE;
        memo = new int[len+1][26][26];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        for (int secondIndex = 0; secondIndex < 26; secondIndex++) {
            int firstIndex = arr[0] - 'A';
            if (secondIndex == firstIndex){
                continue;
            }
            min = Math.min(min, backTrack(0, firstIndex, secondIndex));
        }

        return min;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem04().minimumDistance("CAKE"));
        System.out.println(new Problem04().minimumDistance("YEAR"));
        System.out.println(new Problem04().minimumDistance("AAAAAA"));
    }

}
