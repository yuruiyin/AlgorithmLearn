package contest.contest318;

import java.util.*;

public class D {

    private static final long MAX = (long) 1E12;

    private int[] robotArr;
    private int robotLen;
    private int factoryLen;
    private int[] sufLimitSumArr;
    private long[][] memo;
    private int[] factoryPosArr;
    private int[] factoryLimitArr;

    private long dfs(int robotIdx, int factoryIdx) {
        if (robotIdx == robotLen) {
            return 0;
        }

        if (factoryIdx == factoryLen || robotLen - robotIdx > sufLimitSumArr[factoryIdx]) {
            return MAX;
        }

        if (memo[robotIdx][factoryIdx] != -1) {
            return memo[robotIdx][factoryIdx];
        }

        // 当前工厂可以修的机器人的结果取最小值
        long ansMin = dfs(robotIdx, factoryIdx + 1);
        int limit = factoryLimitArr[factoryIdx];
        long sumDis = 0;
        for (int i = 1; i <= limit; i++) {
            int tmpRobotIdx = robotIdx + i - 1;
            if (tmpRobotIdx >= robotLen) {
                break;
            }
            sumDis += Math.abs(robotArr[tmpRobotIdx] - factoryPosArr[factoryIdx]);
            long tmpRes = dfs(robotIdx + i, factoryIdx + 1) + sumDis;
            if (tmpRes < ansMin) {
                ansMin = tmpRes;
            }
        }

        return memo[robotIdx][factoryIdx] = ansMin;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        this.robotLen = robot.size();
        this.factoryLen = factory.length;
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

        this.sufLimitSumArr = new int[factoryLen];
        sufLimitSumArr[factoryLen - 1] = factory[factoryLen - 1][1];
        for (int i = factoryLen - 2; i >= 0; i--) {
            sufLimitSumArr[i] = sufLimitSumArr[i + 1] + factory[i][1];
        }

        memo = new long[robotLen][factoryLen];
        for (int i = 0; i < robotLen; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0);
    }

}
