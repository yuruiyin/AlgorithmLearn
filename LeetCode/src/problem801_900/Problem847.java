package problem801_900;

public class Problem847 {

    private int[][] graph;
    private int totalNodeCount;  // 总节点数
    private int ansMinLen = Integer.MAX_VALUE;  // 访问所有节点的最小路径长度

    // 计算已经访问过的不同节点数（同一节点出现多次，就计一次）
    private int calcVisitedCount(int[] visitedNodeCountArr) {
        int ans = 0;
        for (int count : visitedNodeCountArr) {
            if (count > 0) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 递归暴力寻找访问所有节点的最短路径
     * @param curNode 当前节点
     * @param visitedNodeCountArr 访问过的节点出现的次数（一个节点可能被多次访问）
     * @param level 当前递归深度（也就是路径长度）
     * @param edgeVisited 标记访问过的有向边，避免同一条路径上重复访问同一有向边
     */
    private void backTrack(int curNode, int[] visitedNodeCountArr, int level, boolean[][] edgeVisited) {
        if (level >= ansMinLen) {
            return;
        }

        visitedNodeCountArr[curNode]++;

        int visitedNodeCount = calcVisitedCount(visitedNodeCountArr);
        if (totalNodeCount - visitedNodeCount + level >= ansMinLen) {
            // 剩下的未访问的节点数 + 当前的路径 如果已经超过当前最小值，说明当前路径长度不可能更小了，直接返回即可
            visitedNodeCountArr[curNode]--;
            return;
        }

        if (visitedNodeCount == totalNodeCount) {
            ansMinLen = level;
            visitedNodeCountArr[curNode]--;
            return;
        }

        for (int nextNode : graph[curNode]) {
            if (edgeVisited[curNode][nextNode]) {
                // 当前路径上，访问过的有向边避免重复访问，防止死循环
                continue;
            }

            edgeVisited[curNode][nextNode] = true;
            backTrack(nextNode, visitedNodeCountArr, level + 1, edgeVisited);
            edgeVisited[curNode][nextNode] = false;
        }

        visitedNodeCountArr[curNode]--;
    }

    public int shortestPathLength(int[][] graph) {
        this.graph = graph;
        totalNodeCount = graph.length;

        for (int i = 0; i < totalNodeCount; i++) {
            backTrack(i, new int[totalNodeCount], 0, new boolean[totalNodeCount][totalNodeCount]);
        }

        return ansMinLen;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1,2,3},
                {0},
                {0},
                {0}
        };

//        int[][] graph = new int[][]{
//                {1},
//                {0,2,4},
//                {1,3,4},
//                {2},
//                {1,2}
//        };
        
        System.out.println(new Problem847().shortestPathLength(graph));
    }

}
