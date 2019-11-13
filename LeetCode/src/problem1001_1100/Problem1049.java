package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1049 {

    private int ansMin = Integer.MAX_VALUE;

    private boolean dfs(List<Integer> curStoneList) {
        int curStoneSize = curStoneList.size();
        if (curStoneSize <= 1) {
            int res = curStoneSize == 1 ? curStoneList.get(0) : 0;
            if (res < ansMin) {
                ansMin = res;
            }

            return ansMin == 0;
        }

        boolean[] visited = new boolean[curStoneSize];
        for (int i = 0; i < curStoneSize; i++) {
            for (int j = i + 1; j < curStoneSize; j++) {
                if (visited[i] || visited[j]) {
                    continue;
                }

                int diff = Math.abs(curStoneList.get(i) - curStoneList.get(j));
                List<Integer> newStoneList = new ArrayList<>(curStoneList);
                newStoneList.remove(i);
                newStoneList.remove(j-1);
                if (diff > 0) {
                    newStoneList.add(diff);
                }

                visited[i] = true;
                visited[j] = true;
                boolean isZero = dfs(newStoneList);
                visited[i] = false;
                visited[j] = false;

                if (isZero) {
                    return true;
                }
            }
        }

        return false;
    }

    public int lastStoneWeightII(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int stone: stones) {
            stoneList.add(stone);
        }

        dfs(stoneList);
        return ansMin;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1049().lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }
    
}
