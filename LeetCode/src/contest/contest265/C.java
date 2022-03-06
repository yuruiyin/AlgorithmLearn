package contest.contest265;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/31
 */
public class C {

    private int[] bfs(int[] arr, int start) {
        int[] ansArr = new int[1001];
        Arrays.fill(ansArr, -1);
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[1001];
        ansArr[start] = 0;
        visited[start] = true;
        queue.add(start);
        int l = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            l++;
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                for (int j = 0; j < arr.length; j++) {
                    int left = x + arr[j];
                    int right = x - arr[j];
                    int xor = x ^ arr[j];
                    if (left >= 0 && left <= 1000 && !visited[left]) {
                        visited[left] = true;
                        ansArr[left] = l;
                        queue.add(left);
                    }
                    if (right >= 0 && right <= 1000 && !visited[right]) {
                        visited[right] = true;
                        ansArr[right] = l;
                        queue.add(right);
                    }
                    if (xor >= 0 && xor <= 1000 && !visited[xor]) {
                        visited[xor] = true;
                        ansArr[xor] = l;
                        queue.add(xor);
                    }
                }
            }
        }

        return ansArr;
    }

    public int minimumOperations(int[] arr, int start, int goal) {
        int[] resArr = bfs(arr, start);
        if (goal < 0 || goal > 1000) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                int left = goal - arr[i];
                int right = goal + arr[i];
                int xor = goal ^ arr[i];
                if (left >= 0 && left <= 1000) {
                    if (resArr[left] != -1) {
                        min = Math.min(min, resArr[left] + 1);
                    }
                }
                if (right >= 0 && right <= 1000) {
                    if (resArr[right] != -1) {
                        min = Math.min(min, resArr[right] + 1);
                    }
                }
                if (xor >= 0 && xor <= 1000) {
                    if (resArr[xor] != -1) {
                        min = Math.min(min, resArr[xor] + 1);
                    }
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        } else {
            return resArr[goal];
        }
    }

}
