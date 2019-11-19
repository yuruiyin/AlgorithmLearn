package problem001_100;

public class Problem091 {

    private int[] memo;

    private int backTrack(char[] arr, int from) {
        int len = arr.length;
        if(from == len) {
            return 1;
        }

        if (from == len - 1) {
            return arr[len - 1] == '0' ? 0 : 1 ; // 单独一个0没有对应编码
        }

        if (arr[from] == '0') {
            return 0;
        }

        if (memo[from] != 0) {
            return memo[from];
        }

        int chooseOneCharRes = backTrack(arr, from+1);
        int twoCharNum = (arr[from] - '0') * 10 + arr[from+1] - '0';
        if (twoCharNum > 26) {
            // 只能选一个字符
            memo[from] = chooseOneCharRes;
            return chooseOneCharRes;
        }

        int chooseTwoCharRes = backTrack(arr, from+2);
        memo[from] = chooseOneCharRes + chooseTwoCharRes;
        return memo[from];
    }

    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        memo = new int[arr.length];
        return backTrack(arr, 0);
    }

    public static void main(String[] args) {

    }
    
}
