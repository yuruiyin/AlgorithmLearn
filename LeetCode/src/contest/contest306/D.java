package contest.contest306;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D {

    private int n;

    private Set<Integer> numList;

    private void rec(int tmpNum, boolean[] visited) {
        if (tmpNum > n) {
            return;
        }

        numList.add(tmpNum);
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            rec(tmpNum * 10 + i, visited);
            visited[i] = false;
        }
    }

    public int countSpecialNumbers(int n) {
        this.n = n;
        numList = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            boolean[] visited = new boolean[10];
            visited[i] = true;
            rec(i, visited);
        }
        return numList.size();
    }

}
