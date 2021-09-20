package contest.contest242;

import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/23
 */
public class C {

    private char[] arr;
    private int len;
    private int min;
    private int max;

    private boolean bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[len];
        queue.add(0);
        visited[0] = true;

        int r = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int next = queue.poll();
                if (next == len - 1) {
                    return true;
                }

                int left = Math.max(r + 1, next + min);
                int right = Math.min(next + max, len - 1);
                for (int j = left; j <= right; j++) {
                    if (arr[j] == '1' || visited[j]) {
                        continue;
                    }

                    visited[j] = true;
                    queue.add(j);
                }
                r = Math.max(r, next + max);
            }
        }

        return false;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        this.arr = s.toCharArray();
        this.len = arr.length;
        this.min = minJump;
        this.max = maxJump;
        if (arr[len - 1] != '0') {
            return false;
        }

        return bfs();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append('0');
        }

        System.out.println(new C().canReach(sb.toString(), 1, 1000));
    }

}
