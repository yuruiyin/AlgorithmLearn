package lcp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class Problem09 {

    public int minJump(int[] jump) {
        int n = jump.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        queue.offer(jump[0]);
        int ans = 1;

        if (jump[0] >= n) {
            return ans;
        }

        int from = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int curIdx = queue.poll();

                if (curIdx + jump[curIdx] >= n) {
                    return ans;
                }

                if (!visited[curIdx + jump[curIdx]]) {
                    queue.offer(curIdx + jump[curIdx]);
                    visited[curIdx + jump[curIdx]] = true;
                }

                for (int j = from; j < curIdx; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    queue.offer(j);
                    visited[j] = true;
                }

                if (from < curIdx + 1) {
                    from = curIdx + 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem09().minJump(new int[]{2, 5, 1, 1, 1, 1}));
        System.out.println(new Problem09().minJump(new int[]{3, 5, 1, 1, 1, 1}));
        System.out.println(new Problem09().minJump(new int[]{1,2,3,4,5}));
    }

}
