package contest.contest345;

import java.util.ArrayList;
import java.util.List;

public class A {

    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        int cur = 1;
        visited[1] = true;
        for (int i = 1; ;i++) {
            cur = ((i * k + cur - 1) % n) + 1;
            if (visited[cur]) {
                break;
            }
            visited[cur] = true;
        }
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                ansList.add(i);
            }
        }
        int[] arr = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            arr[i] = ansList.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
