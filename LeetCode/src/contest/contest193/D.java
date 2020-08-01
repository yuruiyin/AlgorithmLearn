package contest.contest193;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/14
 */
public class D {

    class TreeAncestor {

        private int[] parent;
        private List<Integer>[] pathListArr;

        private List<Integer> dfs(int cur) {
            if (cur == -1) {
                return null;
            }

            if (pathListArr[cur] != null) {
                return pathListArr[cur];
            }

            List<Integer> resList = new ArrayList<>();
            resList.add(parent[cur]);
            List<Integer> parentList = dfs(parent[cur]);
            if (parentList != null) {
                resList.addAll(parentList);
            }

            pathListArr[cur] = resList;
            return resList;
        }

        public TreeAncestor(int n, int[] parent) {
            this.parent = parent;
            pathListArr = new ArrayList[n];
        }

        public int getKthAncestor(int node, int k) {
            pathListArr[node] = dfs(node);
            List<Integer> pathList = pathListArr[node];
            if (pathList == null || pathList.size() < k) {
                return  -1;
            }

            return pathList.get(k - 1);
        }
    }

    public static void main(String[] args) {

    }

}
