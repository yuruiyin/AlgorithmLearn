package contest.contest087;

public class Problem847 {

    private int[][] graph;
    private int nodeLen;
    private int ansLen = Integer.MAX_VALUE;

    private int calcVisitedCount(int[] nodeCountMap) {
        int ans = 0;
        for (int count : nodeCountMap) {
            if (count > 0) {
                ans++;
            }
        }

        return ans;
    }

    private void backTrack(int from, int[] nodeCountMap, int level, boolean[][] edgeVisited) {
        if (level >= ansLen) {
            return;
        }

        nodeCountMap[from]++;

        int visitedNodeCount = calcVisitedCount(nodeCountMap);
        if (nodeLen - visitedNodeCount + level >= ansLen) {
            // 剩下的未访问的节点数 + 当前的路径 如果已经炒作当前最小值，说明当前路径长度不可能更小了，直接返回即可
            nodeCountMap[from]--;
            return;
        }

        if (visitedNodeCount == nodeLen) {
            ansLen = level;
            nodeCountMap[from]--;
            return;
        }

        for (int nextNode : graph[from]) {
            if (edgeVisited[from][nextNode]) {
                continue;
            }

            edgeVisited[from][nextNode] = true;
            backTrack(nextNode, nodeCountMap, level + 1, edgeVisited);
            edgeVisited[from][nextNode] = false;
        }

        nodeCountMap[from]--;
    }

    public int shortestPathLength(int[][] graph) {
        this.graph = graph;
        nodeLen = graph.length;

        for (int i = 0; i < nodeLen; i++) {
            backTrack(i, new int[nodeLen], 0, new boolean[nodeLen][nodeLen]);
        }

        return ansLen;
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
