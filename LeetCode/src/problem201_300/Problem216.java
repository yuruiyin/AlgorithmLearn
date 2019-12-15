package problem201_300;

import java.util.*;

public class Problem216 {

    private List<List<Integer>> ansList;
    private Set<String> visitedSet;

    private void backTrack(int k, int n, boolean[] visited) {
        if (k == 0 && n != 0) {
            return;
        }

        if (9*k < n) {
            return;
        }

        StringBuilder keySb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            if (visited[i]) {
                keySb.append(i);
            }
        }
        keySb.append('_').append(k).append('_').append(n);
        String key = keySb.toString();

        if (visitedSet.contains(key)) {
            return;
        }

        visitedSet.add(key);

        if (k == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                if (visited[i]) {
                    list.add(i);
                }
            }
            ansList.add(list);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            backTrack(k-1, n-i, visited);
            visited[i] = false;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        ansList = new ArrayList<>();
        visitedSet = new HashSet<>();
        backTrack(k, n,  new boolean[10]);
        return ansList;
    }

}
