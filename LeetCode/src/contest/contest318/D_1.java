package contest.contest318;

import java.util.*;

public class D_1 {

    private List<Integer> robot;
    private int[][] factory;
    private int robotLen;
    private int factoryLen;
    private int[] sufLimitSumArr;
    private Long[][][] memo;

    private static final long MAX = (long) 1E12;

    private long dfs(int robotIdx, int factoryIdx, int used) {
        if (robotIdx == robotLen) {
            return 0;
        }

        if (factoryIdx == factoryLen) {
            return MAX;
        }

        if (robotLen - robotIdx > sufLimitSumArr[factoryIdx] - used) {
            return MAX;
        }

        if (used == factory[factoryIdx][1]) {
            return dfs(robotIdx, factoryIdx + 1, 0);
        }

        if (memo[robotIdx][factoryIdx][used] != null) {
            return memo[robotIdx][factoryIdx][used];
        }
        return memo[robotIdx][factoryIdx][used] = Math.min(
                dfs(robotIdx + 1, factoryIdx, used + 1) + Math.abs(robot.get(robotIdx) - factory[factoryIdx][0]),
                dfs(robotIdx, factoryIdx + 1, 0)
        );
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        this.robotLen = robot.size();
        this.factoryLen = factory.length;
        this.robot = robot;
        this.factory = factory;
        Collections.sort(robot);
        Arrays.sort(factory, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        this.sufLimitSumArr = new int[factoryLen];
        sufLimitSumArr[factoryLen - 1] = factory[factoryLen - 1][1];
        for (int i = factoryLen - 2; i >= 0; i--) {
            sufLimitSumArr[i] = sufLimitSumArr[i + 1] + factory[i][1];
        }

        memo = new Long[robotLen][factoryLen][101];
        return dfs(0, 0, 0);
    }

}
