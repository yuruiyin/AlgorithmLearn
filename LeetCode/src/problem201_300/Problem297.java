package problem201_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem297 {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<String> ansList = new ArrayList<>();
            ansList.add(String.valueOf(root.val));

            while (!queue.isEmpty()) {
                List<TreeNode> nodeList = new ArrayList<>();
                while (!queue.isEmpty()) {
                    nodeList.add(queue.removeFirst());
                }

                for (TreeNode node : nodeList) {
                    if (node.left != null) {
                        queue.add(node.left);
                        ansList.add(String.valueOf(node.left.val));
                    } else {
                        ansList.add("null");
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                        ansList.add(String.valueOf(node.right.val));
                    } else {
                        ansList.add("null");
                    }
                }
            }

            int size = ansList.size();
            int lastIndex = size - 1;
            for (int i = size - 1; i >= 0; i--) {
                String str = ansList.get(i);
                if (!str.equals("null")) {
                    lastIndex = i;
                    break;
                }
            }

            // 需要删除最后连续的“null”
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i <= lastIndex; i++) {
                String str = ansList.get(i);
                sb.append(str);
                if (i != size - 1) {
                    sb.append(",");
                }
            }

            sb.append("]");

            return sb.toString();
        }

        private TreeNode deserializeByDfs(String[] arr, int index) {
            if (index >= arr.length) {
                return null;
            }

            String str = arr[index];
            if (str.equals("null")) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.left = deserializeByDfs(arr, 2 * index + 1);
            root.right = deserializeByDfs(arr, 2 * index + 2);

            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }

            StringBuilder sb = new StringBuilder(data);

            // 去除'['和']'
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);

            String[] arr = sb.toString().split(",");

            int len = arr.length;

            LinkedList<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            queue.add(root);
            int nextLevelStart = 1; //下一层次的第一个节点的索引

            while (!queue.isEmpty()) {
                List<TreeNode> nodeList = new ArrayList<>();
                while (!queue.isEmpty()) {
                    nodeList.add(queue.removeFirst());
                }

                int index = nextLevelStart;
                for (TreeNode node : nodeList) {
                    for (int i = 0; i <= 1; i++) {
                        int tmpIndex = index + i;
                        if (tmpIndex == len) {
                            return root;
                        }

                        String str = arr[tmpIndex];
                        if (!str.equals("null")) {
                            TreeNode treeNode = new TreeNode(Integer.parseInt(str));
                            if (i == 0) {
                                node.left = treeNode;
                            } else {
                                node.right = treeNode;
                            }
                            queue.add(treeNode);
                        }
                    }

                    index += 2;
                }

                nextLevelStart = index;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        new Codec().deserialize("[]");
    }

}
