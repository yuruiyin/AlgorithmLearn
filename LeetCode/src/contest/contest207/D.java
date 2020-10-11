package contest.contest207;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/20
 */
public class D {

    class Edge {
        int i;
        int j;
        int cost;
        Edge(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    private boolean isAllVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public int connectTwoGroups(List<List<Integer>> costs) {
        int rowCount = costs.size();
        int colCount = costs.get(0).size();
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                list.add(new Edge(i, j, costs.get(i).get(j)));
            }
        }

        list.sort(Comparator.comparingInt(o -> o.cost));
        boolean[] visited1 = new boolean[rowCount];
        boolean[] visited2 = new boolean[colCount];
        int edgeSize = list.size();
        boolean[] edgeVisited = new boolean[edgeSize];
        int ans = 0;
        while (!(isAllVisited(visited1) && isAllVisited(visited2))) {
            for (int index = 0; index < edgeSize; index++) {
                if (edgeVisited[index]) {
                    continue;
                }
                Edge edge = list.get(index);
                int i = edge.i;
                int j = edge.j;
                int cost = edge.cost;
                if (!visited1[i] && !visited2[j]) {
                    ans += cost;
                    visited1[i] = true;
                    visited2[j] = true;
                    edgeVisited[index] = true;
                }
            }

            for (int index = 0; index < edgeSize; index++) {
                if (edgeVisited[index]) {
                    continue;
                }
                Edge edge = list.get(index);
                int i = edge.i;
                int j = edge.j;
                int cost = edge.cost;
                if (!visited1[i]) {
                    ans += cost;
                    visited1[i] = true;
                    edgeVisited[index] = true;
                }
            }

            for (int index = 0; index < edgeSize; index++) {
                if (edgeVisited[index]) {
                    continue;
                }
                Edge edge = list.get(index);
                int i = edge.i;
                int j = edge.j;
                int cost = edge.cost;
                if (!visited2[j]) {
                    ans += cost;
                    visited2[j] = true;
                    edgeVisited[index] = true;
                }
            }
        }

        return ans;

    }

}
