package contest.contest202;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/16
 */
public class D {

    class Node {
        int cur;
        int len;
        Node(int cur, int len) {
            this.cur =cur;
            this.len = len;
        }
    }

    private int bfs(int n) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        Set<Integer> visitedSet = new HashSet<>();
        int ans = 0;
        Map<Integer, Integer> minDisMap = new HashMap<>();
        minDisMap.put(n, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.cur == 1) {
                    return ans + 1;
                }

                int cur = node.cur;

                if (cur % 3 == 0 && (!visitedSet.contains(cur / 3) || minDisMap.get(cur / 3) > ans + 1)) {
                    queue.add(new Node(cur / 3, ans + 1));
                    minDisMap.put(cur / 3, ans + 1);
                    visitedSet.add(cur / 3);
                }

                if (cur % 2 == 0 && (!visitedSet.contains(cur / 2) || minDisMap.get(cur / 2) > ans + 1)) {
                    queue.add(new Node(cur / 2, ans + 1));
                    minDisMap.put(cur / 2, ans + 1);
                    visitedSet.add(cur / 2);
                }

                if (!visitedSet.contains(cur - 1) || minDisMap.get(cur - 1) > ans + 1) {
                    queue.add(new Node(cur - 1, ans + 1));
                    minDisMap.put(cur - 1, ans + 1);
                    visitedSet.add(cur - 1);
                }
            }
            ans++;
        }

        return ans;
    }

    public int minDays(int n) {
        return bfs(n);
    }
    
    public static void main(String[] args) {
        System.out.println(new D().minDays(429));
        System.out.println(new D().minDays(764));
    }

}
