package contest.contest167;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem04 {

    class Node {
        int row;
        int col;
        int oneCount;  // bfs过程中某一条路径到达该节点时的路径上的1的个数
        int pathLen;   // bfs过程中到达某一节点的路径的长度（即走过的步数）
        Node (int row, int col, int oneCount, int pathLen) {
            this.row = row;
            this.col = col;
            this.oneCount = oneCount;
            this.pathLen = pathLen;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<Node> queue = new LinkedList<>();
        Node rootNode = new Node(0, 0, 0, 0);
        queue.add(rootNode);
        Node[][] visited = new Node[m][n];
        visited[0][0] = rootNode;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (!queue.isEmpty()) {
            List<Node> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            for (Node node : nodeList) {
                int row = node.row;
                int col = node.col;
                int oneCount = node.oneCount;
                int pathLen = node.pathLen;

                // 通过bfs到达终点，那么就是最短路径
                if (row == m - 1 && col == n - 1) {
                    return pathLen;
                }

                // 上下左右四个方向
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dx[i];
                    int nextCol = col + dy[i];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    int curOneCount = grid[nextRow][nextCol] == 1 ? oneCount + 1 : oneCount;
                    if (curOneCount <= k) { // 这里判断是关键，也就是说进入队列的路径上的1的个数都必须<=k，这样就能消除
                        if (visited[nextRow][nextCol] == null || curOneCount < visited[nextRow][nextCol].oneCount) {
                            // curOneCount < visited[nextRow][nextCol].oneCount
                            // 这个判断条件是只有新路径的1的个数小于旧路径1的个数的时候，才需要加入到队列中。
                            Node nextNode = new Node(nextRow, nextCol, curOneCount, pathLen + 1);
                            queue.add(nextNode);
                            visited[nextRow][nextCol] = nextNode;
                        }
                    }
                }
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        
    }
    
}
