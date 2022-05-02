package spring_2022_group;

import java.util.*;

public class C {

    private Map<Integer, Set<Integer>> time2PosMap;
    private List<Integer> timeList;
    private int timeSize;
    private Integer[][][] memo;

    private int dp(int x, int y, int timeIdx) {
        if (timeIdx == timeSize) {
            return 0;
        }

        if (memo[x][y][timeIdx] != null) {
            return memo[x][y][timeIdx];
        }

        int time = timeList.get(timeIdx);
        Set<Integer> posSet = time2PosMap.get(time);
        int ansMax = 0;
        for (int nextX = 0; nextX < 3; nextX++) {
            for (int nextY = 0; nextY < 3; nextY++) {
                int needTime = Math.abs(nextX - x) + Math.abs(nextY - y);
                int timeDiff = timeIdx == 0 ? time : time - timeList.get(timeIdx - 1);
                if (timeDiff < needTime) {
                    continue;
                }

                int offset = posSet.contains(nextX * 3 + nextY) ? 1 : 0;
                ansMax = Math.max(ansMax, dp(nextX, nextY, timeIdx + 1) + offset);
            }
        }

        memo[x][y][timeIdx] = ansMax;
        return ansMax;
    }

    public int getMaximumNumber(int[][] moles) {
        time2PosMap = new HashMap<>();
        Set<Integer> timeSet = new HashSet<>();
        for (int[] mole : moles) {
            int time = mole[0];
            int x = mole[1];
            int y = mole[2];
            if (!time2PosMap.containsKey(time)) {
                time2PosMap.put(time, new HashSet<>());
            }
            time2PosMap.get(time).add(x * 3 + y);
            timeSet.add(time);
        }
        timeList = new ArrayList<>(timeSet);
        Collections.sort(timeList);
        timeSize = timeList.size();

        memo = new Integer[3][3][timeSize];
        return dp(1, 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(new C().getMaximumNumber(new int[][]{{1,1,0},{2,0,1},{4,2,2}}));
        System.out.println("hello world");
    }

}
