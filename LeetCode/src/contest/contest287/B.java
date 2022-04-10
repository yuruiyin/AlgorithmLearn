package contest.contest287;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B {

    public List<List<Integer>> findWinners(int[][] matches) {
        boolean[] visited = new boolean[100001];
        int[] looseCountArr = new int[100001];
        for (int[] match : matches) {
            int win = match[0];
            int loose = match[1];
            visited[win] = true;
            visited[loose] = true;
            looseCountArr[loose]++;
        }

        List<List<Integer>> ansList = new ArrayList<>();
        ansList.add(new ArrayList<>());
        ansList.add(new ArrayList<>());
        for (int i = 1; i < 100001; i++) {
            if (looseCountArr[i] == 0 && visited[i]) {
                ansList.get(0).add(i);
            } else if (looseCountArr[i] == 1 && visited[i]) {
                ansList.get(1).add(i);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
