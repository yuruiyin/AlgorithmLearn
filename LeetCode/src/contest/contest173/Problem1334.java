package contest.contest173;

import java.util.*;

public class Problem1334 {

    class Node {
        int id;
        int w;
        Node(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }

    private int n;

    private List<Integer> bfs(List<Node>[] adj, int from, int distanceThreshold) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(from, 0));
        Node[] visited = new Node[n];
        visited[from] = new Node(from, 0);
        Set<Integer> ansSet = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (adj[node.id] == null) {
                    continue;
                }
                for (Node next : adj[node.id]) {
                    if (node.w + next.w > distanceThreshold) {
                        continue;
                    }
                    if (visited[next.id] != null && node.w + next.w >= visited[next.id].w) {
                        continue;
                    }

                    ansSet.add(next.id);
                    visited[next.id] = new Node(next.id, node.w + next.w);
                    queue.add(visited[next.id]);
                }
            }
        }

        return new ArrayList<>(ansSet);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //bfs
        this.n = n;
        List<Node>[] adj = new ArrayList[n];

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];

            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }

            adj[from].add(new Node(to, w));

            if (adj[to] == null) {
                adj[to] = new ArrayList<>();
            }

            adj[to].add(new Node(from, w));
        }

        List<Integer> ansList = new ArrayList<>();
        int size = n;
        int ansId = -1;
        for (int i = 0; i < n; i++) {
            List<Integer> tmpList = bfs(adj, i, distanceThreshold);
            if (tmpList.size() <= size) {
                ansList = tmpList;
                ansId = i;
                size = ansList.size();
            }
        }

        return ansId;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1334().findTheCity(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
    }

}

//    有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti]
//    代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
//
//        返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
//
//        注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
