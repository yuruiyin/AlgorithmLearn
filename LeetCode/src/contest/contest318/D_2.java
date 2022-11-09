package contest.contest318;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D_2 {

    private static final long MAX = (long) 1E12;

    private int[] robotArr;
    private int[] preLimitSumArr;
    private long[][] memo;
    private int[] factoryPosArr;
    private int[] factoryLimitArr;

    /**
     * 倒着遍历
     */
    private long dfs(int robotIdx, int factoryIdx) {
        if (robotIdx < 0) {
            return 0;
        }

        if (factoryIdx < 0 || robotIdx + 1 > preLimitSumArr[factoryIdx]) {
            return MAX;
        }

        if (memo[robotIdx][factoryIdx] != -1) {
            return memo[robotIdx][factoryIdx];
        }

        if (factoryIdx == 0) {
            long ans = 0;
            int curFactoryPos = factoryPosArr[0];
            for (int i = 0; i <= robotIdx; i++) {
                ans += Math.abs(curFactoryPos - robotArr[i]);
            }
            return memo[robotIdx][factoryIdx] = ans;
        }

        // 当前工厂可以修的机器人的结果取最小值
        long ansMin = dfs(robotIdx, factoryIdx - 1);
        int limit = factoryLimitArr[factoryIdx];
        long sumDis = 0;
        int curFactoryPos = factoryPosArr[factoryIdx];
        for (int i = 1; i <= limit; i++) {
            int tmpRobotIdx = robotIdx - i + 1;
            if (tmpRobotIdx < 0) {
                break;
            }
            sumDis += Math.abs(robotArr[tmpRobotIdx] - curFactoryPos);
            long tmpRes = dfs(robotIdx - i, factoryIdx - 1) + sumDis;
            if (tmpRes < ansMin) {
                ansMin = tmpRes;
            }
        }

        return memo[robotIdx][factoryIdx] = ansMin;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int robotLen = robot.size();
        int factoryLen = factory.length;
        this.robotArr = new int[robotLen];
        for (int i = 0; i < robotLen; i++) {
            robotArr[i] = robot.get(i);
        }
        Arrays.sort(robotArr);
        Arrays.sort(factory, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        factoryPosArr = new int[factoryLen];
        factoryLimitArr = new int[factoryLen];
        for (int i = 0; i < factoryLen; i++) {
            factoryPosArr[i] = factory[i][0];
            factoryLimitArr[i] = factory[i][1];
        }

        this.preLimitSumArr = new int[factoryLen];
        preLimitSumArr[0] = factoryLimitArr[0];
        for (int i = 1; i < factoryLen; i++) {
            preLimitSumArr[i] = preLimitSumArr[i - 1] + factoryLimitArr[i];
        }

        memo = new long[robotLen][factoryLen];
        for (int i = 0; i < robotLen; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(robotLen - 1, factoryLen - 1);
    }

}
