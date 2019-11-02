package problem301_400;

import utils.PrintUtil;
import java.util.*;

public class Problem399_bfs {

    class Edge {
        String to;
        double value;
        Edge(String to, double value) {
            this.to = to;
            this.value = value;
        }
    }

    class BFSNode {
        String id;
        double sum; // bfs过程中从起始节点到达改节点的累乘的结果
        BFSNode(String id, double sum) {
            this.id = id;
            this.sum = sum;
        }
    }

    private double bfs(Map<String, List<Edge>> adj, String dividend, String targetDivisor) {
        LinkedList<BFSNode> queue = new LinkedList<>();
        queue.addLast(new BFSNode(dividend, 1.0));
        double value = 1.0;
        Set<String> visited = new HashSet<>();
        visited.add(dividend);

        if (targetDivisor.equals(dividend)) {
            return value;
        }

        while (!queue.isEmpty()) {
            List<BFSNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            for (BFSNode node : nodeList) {
                for (Edge edge: adj.get(node.id)) {
                    if (visited.contains(edge.to)) {
                        continue;
                    }

                    if (edge.to.equals(targetDivisor)) {
                        // 找到
                        return node.sum * edge.value;
                    }

                    queue.addLast(new BFSNode(edge.to, node.sum * edge.value));
                }
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> adj = new HashMap<>(); // 图
        int equationSize = equations.size();

        for (int i = 0; i < equationSize; i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            if (adj.containsKey(dividend)) {
                adj.get(dividend).add(new Edge(divisor, values[i]));
            } else {
                List<Edge> neighbors = new ArrayList<>();
                neighbors.add(new Edge(divisor, values[i]));
                adj.put(dividend, neighbors);
            }

            // 反向边
            if (adj.containsKey(divisor)) {
                adj.get(divisor).add(new Edge(dividend, 1 / values[i]));
            } else {
                List<Edge> neighbors = new ArrayList<>();
                neighbors.add(new Edge(dividend, 1 / values[i]));
                adj.put(divisor, neighbors);
            }
        }

        int querySize = queries.size();
        double[] ansArr = new double[querySize];

        for (int i = 0; i < querySize; i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            if (adj.containsKey(dividend) && adj.containsKey(divisor)) {
                ansArr[i] = bfs(adj, dividend, divisor);
            } else {
                ansArr[i] = -1.0;
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));

        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("a", "e")));
        queries.add(new ArrayList<>(Arrays.asList("a", "a")));
        queries.add(new ArrayList<>(Arrays.asList("x", "x")));

        double[] ans = new Problem399_bfs().calcEquation(equations, values, queries);

        PrintUtil.printDoubleArray(ans);
    }

}
