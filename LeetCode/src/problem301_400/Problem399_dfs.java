package problem301_400;

import utils.PrintUtil;

import java.util.*;

/**
 * 思路：构图，边权就是除法的值，如 a/b = 2即a到b之间有一条边，值为2，不过其实是双向边，b到a也有一条边，值为1/2
 */
public class Problem399_dfs {

    private double ans;

    class Edge {
        String to;
        double value;
        Edge(String to, double value) {
            this.to = to;
            this.value = value;
        }
    }

    private boolean dfs(Map<String, List<Edge>> adj, String dividend, String targetDivisor, double value, Set<String> visited) {
        if (dividend.equals(targetDivisor)) {
            // 找到
            ans = value;
            return true;
        }

        for (Edge edge: adj.get(dividend)) {
            if (visited.contains(edge.to)) {
                continue;
            }

            visited.add(edge.to);
            value *= edge.value;
            boolean isFound = dfs(adj, edge.to, targetDivisor, value, visited);
            if (isFound) {
                return true;
            }
            visited.remove(edge.to);
            value /= edge.value;
        }

        return false;
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
                if (dividend.equals(divisor)) {
                    ansArr[i] = 1.0;
                    continue;
                }
                ans = -1.0;
                dfs(adj, dividend, divisor, 1.0, new HashSet<>());
                ansArr[i] = ans;
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

        double[] ans = new Problem399_dfs().calcEquation(equations, values, queries);

        PrintUtil.printDoubleArray(ans);
    }
    
}
