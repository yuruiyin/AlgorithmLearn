package problem1101_1200;

import utils.PrintUtil;

import java.util.*;

public class Problem1192 {

    private static final long N = 100000;

    private ArrayList<Problem1192.Connection>[] pointEdgeList; // 每个点相连的边

    static class Connection {
        int a;
        int b;
        boolean isInCircle;
        Connection(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private void dfs(Set<Long> connectionVisited, Set<Integer> pointVisited, List<Set<Integer>> curPointCircleSetList, int from, int next) {
        if (from == next && !connectionVisited.isEmpty()) {
            // 找到环
            curPointCircleSetList.get(0).addAll(pointVisited);
            return;
        }

        for (Problem1192.Connection connection : pointEdgeList[next]) {
            if (connection.isInCircle) {
                continue;
            }
            long key = connection.a * N + connection.b;
            if (connectionVisited.contains(key)) {
                continue;
            }

            int next1 = connection.a == next ? connection.b : connection.a;
            // 下一个点是否在已有环内，是的话，则将这条路径上的节点都加入到这个环中。
            if (curPointCircleSetList.get(0).contains(next1)) {
                curPointCircleSetList.get(0).addAll(pointVisited);
                continue;
            }

            if (next1 != from && pointVisited.contains(next1)) {
                // 这边构成了一个不包含当前from节点的环
                Set<Integer> circleSet = new HashSet<>();
                List<Integer> pointVisitedList = new ArrayList<>(pointVisited);
                for (int i = pointVisitedList.size() - 1; i >= 0; i--) {
                    Integer point = pointVisitedList.get(i);
                    if (point == next1) {
                        circleSet.add(point);
                        break;
                    }
                    circleSet.add(point);
                }

                curPointCircleSetList.add(circleSet);
                continue;
            }

            connectionVisited.add(key);
            pointVisited.add(next1);
            dfs(connectionVisited, pointVisited, curPointCircleSetList, from, next1);
            connectionVisited.remove(key);
            pointVisited.remove(next1);
        }

    }

    /**
     * 计算每个节点相连的边
     */
    private void calcPointEdgeList(int n, List<Problem1192.Connection> connections) {
        // 计算每个节点相连的边
        pointEdgeList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            pointEdgeList[i] = new ArrayList();
        }

        for (Problem1192.Connection connection: connections) {
            pointEdgeList[connection.a].add(connection);
            pointEdgeList[connection.b].add(connection);
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (n == 1) {
            return new ArrayList<>();
        }

        if (n == 2) {
            return connections;
        }

        List<Problem1192.Connection> connectionList = new ArrayList<>();

        for (List<Integer> connection : connections) {
            connectionList.add(new Problem1192.Connection(connection.get(0), connection.get(1)));
        }

        calcPointEdgeList(n, connectionList);

        // 记录点在是否在环中，在环中说明点所连的边就不是题目要求的关键链接
        Set<Integer> pointInCircleSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (pointInCircleSet.contains(i)) {
                continue;
            }

            Set<Integer> tmpPointVisited = new TreeSet<>();
            tmpPointVisited.add(i);
            List<Set<Integer>> curPointCircleSetList = new ArrayList<>(); // 多个环
            curPointCircleSetList.add(new HashSet<>()); // 当前i节点所在的环放到列表第一个位置
            dfs(new HashSet<>(), tmpPointVisited, curPointCircleSetList, i, i);

            for (Set<Integer> set: curPointCircleSetList) {
                pointInCircleSet.addAll(set);
            }

            // 标记哪些边在环上
            for (Problem1192.Connection connection: connectionList) {
                for (Set<Integer> set: curPointCircleSetList) {
                    if (set.contains(connection.a) && set.contains(connection.b)) {
                        connection.isInCircle = true;
                        break;
                    }
                }
            }
        }

        List<List<Integer>> ansList = new ArrayList<>();
        for (Problem1192.Connection connection: connectionList) {
            if (!connection.isInCircle) {
                ansList.add(new ArrayList<>(Arrays.asList(connection.a, connection.b)));
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
//        List<List<Integer>> connections = new ArrayList<>();
//        connections.add(new ArrayList<>(Arrays.asList(0,1)));
//        connections.add(new ArrayList<>(Arrays.asList(1,2)));
//        connections.add(new ArrayList<>(Arrays.asList(2,0)));
//        connections.add(new ArrayList<>(Arrays.asList(1,3)));
//
//        List<List<Integer>> ansList = new Problem1192().criticalConnections(4, connections);
//
//        PrintUtil.printIntListList(ansList); // 1,3

        List<List<Integer>> connections1 = new ArrayList<>();
        connections1.add(new ArrayList<>(Arrays.asList(0,1)));
        connections1.add(new ArrayList<>(Arrays.asList(1,2)));
        connections1.add(new ArrayList<>(Arrays.asList(2,0)));
        connections1.add(new ArrayList<>(Arrays.asList(1,3)));
        connections1.add(new ArrayList<>(Arrays.asList(3,4)));
        connections1.add(new ArrayList<>(Arrays.asList(4,5)));
        connections1.add(new ArrayList<>(Arrays.asList(5,3)));

        List<List<Integer>> ansList1 = new Problem1192().criticalConnections(6, connections1);

        PrintUtil.printIntListList(ansList1);  // 1,3
    }

}
