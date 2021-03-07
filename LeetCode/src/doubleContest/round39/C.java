package doubleContest.round39;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/14
 */
public class C {

    class Node {
        int pos;
        int maxBackCount;
        int continueBackCount;
        Node(int pos, int maxBackCount, int continueBackCount) {
            this.pos = pos;
            this.maxBackCount = maxBackCount;
            this.continueBackCount = continueBackCount;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // bfs
        boolean[] isForbidden = new boolean[400001];
        for (int num : forbidden) {
            isForbidden[num] = true;
        }

        boolean[] visited = new boolean[400001];
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        int level = 0;
        visited[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.pos == x && node.maxBackCount <= 1) {
                    return level;
                }

                if (node.pos + a <= 400000 && !isForbidden[node.pos + a] && !visited[node.pos + a]) {
                    queue.add(new Node(node.pos + a, node.maxBackCount, 0));
                    visited[node.pos + a] = true;
                }

                if (node.pos - b >= 0 && !isForbidden[node.pos - b] && !visited[node.pos - b]) {
                    queue.add(new Node(node.pos - b, Math.max(node.maxBackCount, node.continueBackCount + 1), node.continueBackCount + 1));
                    visited[node.pos - b] = true;
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new C().minimumJumps(new int[]{162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98},
                29, 98, 80));
    }

}
