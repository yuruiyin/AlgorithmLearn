package problem001_100;

import java.util.ArrayList;
import java.util.List;

public class Problem060 {

    private String ansStr;

    private int count = 0;

    private String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        for (Integer num: list) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void backTrack(int n, int k, boolean[] visited, List<Integer> tmpList) {
        if (count == k) {
            return;
        }
        if (tmpList.size() == n) {
            count++;
            if (count == k) {
                ansStr = listToString(tmpList);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (count == k) {
                return;
            }
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            tmpList.add(i);
            backTrack(n, k, visited, tmpList);
            tmpList.remove(tmpList.size() - 1);
            visited[i] = false;
        }
    }

    public String getPermutation(int n, int k) {
        backTrack(n, k, new boolean[n + 1], new ArrayList<>());
        return ansStr;
    }

    public static void main(String[] args) {
        System.out.println(new Problem060().getPermutation(3, 3));
        System.out.println(new Problem060().getPermutation(4, 9));
    }

}
