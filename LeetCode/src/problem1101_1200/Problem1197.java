package problem1101_1200;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Problem1197 {

    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (!(obj instanceof Node)) {
                return false;
            }

            Node otherNode = (Node) obj;

            return otherNode.x == this.x && otherNode.y == this.y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }

    public int minKnightMoves(int targetX, int targetY) {
        // BFS
        int[][] diff = new int[][]{
                {-2,-1},
                {-2,1},
                {-1,-2},
                {-1,2},
                {1,-2},
                {1,2},
                {2,-1},
                {2,1},
        };

        LinkedList<Node> queue = new LinkedList<>();
        Node startNode = new Node(0, 0 );
        queue.add(startNode);
        Set<Node> visited = new HashSet<>();  // 已经走过的点就不要重复走了
        visited.add(startNode);


        int ans = 0;
        while (!queue.isEmpty()) {
            Set<Node> nodeSet = new HashSet<>();
            // 取出队列的所有节点
            int minDistance = Integer.MAX_VALUE; // 当前最小的距离
            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (node.x == targetX && node.y == targetY) {
                    return ans;
                }
                int distance = Math.abs(node.x - targetX) + Math.abs(node.y - targetY);
                if (distance < minDistance) {
                    // 更新当前最小距离
                    minDistance = distance;
                }
                nodeSet.add(node);
            }
            ans++;

            for (Node node: nodeSet) {
                // 每个节点都有八个方向
                for (int i = 0; i < 8; i++) {
                    Node newNode = new Node(node.x + diff[i][0], node.y + diff[i][1]);
                    int distance = Math.abs(targetX - newNode.x) + Math.abs(targetY - newNode.y);
                    if (distance > 3 && distance >= minDistance) {
                        // 下一点不能更靠近目标，则不考虑。
                        continue;
                    }

                    if (visited.contains(newNode)) {
                        continue;
                    }
                    visited.add(newNode);
                    queue.addLast(newNode);
                }
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem1197().minKnightMoves(2,1));
//        System.out.println(new Problem1197().minKnightMoves(5,5));
        System.out.println(new Problem1197().minKnightMoves(0,1));
//        System.out.println(new Problem1197().minKnightMoves(0,2));
//        System.out.println(new Problem1197().minKnightMoves(0,3));
//        System.out.println(new Problem1197().minKnightMoves(2,112));
        System.out.println(new Problem1197().minKnightMoves(270,-21));
        System.out.println(new Problem1197().minKnightMoves(11,248));
    }
    
}
