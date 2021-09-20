package contest.contest251;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/25
 */
public class C {

    private int[][] students;
    private int[][] mentors;
    private int len;
    private Integer[][] memo;

    private int rec(int stuIdx, int flag) {
        if (stuIdx == len) {
            return 0;
        }

        if (memo[stuIdx][flag] != null) {
            return memo[stuIdx][flag];
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            if ((flag & (1 << i)) != 0) {
                continue;
            }

            int sum = 0;
            for (int j = 0; j < students[stuIdx].length; j++) {
                sum += students[stuIdx][j] == mentors[i][j] ? 1 : 0;
            }
            ansMax = Math.max(ansMax, sum + rec(stuIdx + 1, flag ^ (1 << i)));
        }

        memo[stuIdx][flag] = ansMax;
        return ansMax;
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        this.students = students;
        this.mentors = mentors;
        this.len = students.length;
        memo = new Integer[len][1 << len];
        return rec(0, 0);
    }

}
