package spring_2021_group;

import common.TreeNode;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/10
 */
public class B {

    private Map<TreeNode, List<TreeNode>> adjMap;
    private List<TreeNode> nodeList;
    private Map<TreeNode, Integer> countMap;

    private void dfs(TreeNode parent, TreeNode cur) {
        if (cur == null) {
            return;
        }

        nodeList.add(cur);

        List<TreeNode> adjList = new ArrayList<>();
        if (parent != null) {
            adjList.add(parent);
        }

        if (cur.left != null) {
            adjList.add(cur.left);
            dfs(cur, cur.left);
        }

        if (cur.right != null) {
            adjList.add(cur.right);
            dfs(cur, cur.right);
        }

        adjMap.put(cur, adjList);
    }

//    class Result {
//        int count;
//        boolean isOk;
//        Result(int count, boolean isOk) {
//            this.count = count;
//            this.isOk = isOk;
//        }
//    }

//    private int count = 0;

//    private boolean isOk(TreeNode cur, Set<TreeNode> tmpVisited, int k) {
//        List<TreeNode> adjList = adjMap.get(cur);
//        count++;
//        if (count > k) {
//            return false;
//        }
//        for (TreeNode node : adjList) {
//            if (!visitedSet.contains(node)) {
//                continue;
//            }
//
//            if (tmpVisited.contains(node)) {
//                continue;
//            }
//            tmpVisited.add(node);
//
//            boolean isOk = isOk(node, tmpVisited, k);
//            if (!isOk) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    private boolean bfs(TreeNode cur, int k) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(cur);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(cur);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                count++;
                if (count > k) {
                    countMap.put(cur, k + 1);
                    return false;
                }
                List<TreeNode> adjList = adjMap.get(node);
                for (TreeNode next : adjList) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);

                    if (!countMap.containsKey(next)) {
                        continue;
                    }

                    if (count + countMap.getOrDefault(next, 0) > k) {
                        countMap.put(cur, k + 1);
                        return false;
                    }

                    queue.add(next);
                }
            }
        }

        countMap.put(cur, count);
        return true;
    }

    public int maxValue(TreeNode root, int k) {
        adjMap = new HashMap<>();
        nodeList = new ArrayList<>();
        dfs(null, root);

        nodeList.sort((o1, o2) -> o2.val - o1.val);

        countMap = new HashMap<>();

        int ans = 0;
        for (TreeNode node : nodeList) {
            boolean isOk = bfs(node, k);
            if (isOk) {
                ans += node.val;
            }
        }

//        for (TreeNode node : nodeList) {
//            Set<TreeNode> tmpVisitedSet = new HashSet<>();
//            tmpVisitedSet.add(node);
//            count = 0;
//            boolean isOk = isOk(node, tmpVisitedSet, k);
//            if (isOk) {
//                ans += node.val;
//                visitedSet.add(node);
//            }
//        }

        return ans;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        System.out.println(new B().maxValue(root, 2));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new B().maxValue(root, 1));
//        System.out.println("hello world");
    }

}
