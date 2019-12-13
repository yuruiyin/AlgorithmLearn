package problem501_600;

public class Problem552 {

    private static final int MOD = 1000000007;
    private int len;
    private long[][][] memo;

    private long backTrack(int from, int countA, char lastChar, char lastLastChar) {
        if (from == len) {
            return 1;
        }

        int chooseLTypes;
        if (lastChar != 'L') {
            chooseLTypes = 0;
        } else if (lastLastChar != 'L') {
            chooseLTypes = 1;
        } else {
            chooseLTypes = 2;
        }

        if (memo[from][countA][chooseLTypes] != 0) {
            return memo[from][countA][chooseLTypes];
        }

        long chooseACount = 0;
        if (countA < 1) {
            chooseACount = backTrack(from + 1, countA + 1, 'A', lastChar);
        }

        long chooseLCount = 0;
        if (!(lastChar == 'L' && lastLastChar == 'L')) {
            chooseLCount = backTrack(from + 1, countA, 'L', lastChar);
        }

        long choosePCount = backTrack(from + 1, countA, 'P', lastChar);

        long ansCount = (chooseACount + chooseLCount + choosePCount) % MOD;
        memo[from][countA][chooseLTypes] = ansCount;
        return ansCount;
    }

    public int checkRecord(int n) {
        len = n;
        memo = new long[len][2][3];
        return (int) backTrack(0, 0, ' ', ' ');
    }

}

//  给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。
//
//        学生出勤记录是只包含以下三个字符的字符串：
//
//        'A' : Absent，缺勤
//        'L' : Late，迟到
//        'P' : Present，到场
//        如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
//
//        示例 1:
//
//        输入: n = 2
//        输出: 8
//        解释：
//        有8个长度为2的记录将被视为可奖励：
//        "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
//        只有"AA"不会被视为可奖励，因为缺勤次数超过一次。
//        注意：n 的值不会超过100000。

