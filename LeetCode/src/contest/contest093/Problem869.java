package contest.contest093;

import java.util.ArrayList;
import java.util.List;

public class Problem869 {

    private List<Integer> numList;
    private int len;

    private boolean isMatch(int num) {
        return (num & (num - 1)) == 0;
    }

    private boolean backTrack(int from, boolean[] visited, int num) {
        if (from == len) {
            return isMatch(num);
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            if (from == 0 && numList.get(i) == 0) {
                continue;
            }

            visited[i] = true;
            int oldNum = num;
            num = num * 10 + numList.get(i);
            boolean isFound = backTrack(from + 1, visited, num);
            if (isFound) {
                return true;
            }
            num = oldNum;
            visited[i] = false;
        }

        return false;
    }

    public boolean reorderedPowerOf2(int n) {
        numList = new ArrayList<>();
        while (n > 0) {
            numList.add(n % 10);
            n /= 10;
        }

        len = numList.size();

        return backTrack(0, new boolean[len], 0);
    }

}
