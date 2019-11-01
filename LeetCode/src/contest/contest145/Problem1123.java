package contest.contest145;

import common.TreeNode;

import java.util.*;

public class Problem1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        queue.addLast(root);
        List<TreeNode> lastNodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            lastNodeList = nodeList;

            for (TreeNode node : nodeList) {
                if (node.left != null) {
                    queue.addLast(node.left);
                    parent.put(node.left, node);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                    parent.put(node.right, node);
                }
            }
        }

        // 队列空的时候，lastNodeList就是深度最深的叶子节点
        Set<TreeNode> nodeSet = new HashSet<>(lastNodeList);
        while (nodeSet.size() > 1) {
            Set<TreeNode> tmpNodeSet = new HashSet<>();
            for (TreeNode node : nodeSet) {
                tmpNodeSet.add(parent.get(node));
            }
            nodeSet = tmpNodeSet;
        }

        return nodeSet.iterator().next();
    }
    
    public static void main(String[] args) {

    }
    
}
