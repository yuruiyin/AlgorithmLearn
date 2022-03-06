package contest.contest283;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2022/3/6
 */
public class C {

    public TreeNode createBinaryTree(int[][] descriptions) {
        // 先找出根节点
        Set<Integer> allNodeSet = new HashSet<>();
        Set<Integer> allChildSet = new HashSet<>();

        TreeNode[] treeNodes = new TreeNode[100001];

        for (int[] arr: descriptions) {
            int p = arr[0];
            int c = arr[1];
            if (treeNodes[p] == null) {
                treeNodes[p] = new TreeNode(p);
            }
            if (treeNodes[c] == null) {
                treeNodes[c] = new TreeNode(c);
            }
            allNodeSet.add(p);
            allNodeSet.add(c);
            allChildSet.add(c);
        }

        TreeNode root = null;
        for (Integer node : allNodeSet) {
            if (!allChildSet.contains(node)) {
                root = treeNodes[node];
                break;
            }
        }

        for (int[] arr: descriptions) {
            int p = arr[0];
            int c = arr[1];
            int isLeft = arr[2];
            if (isLeft == 1) {
                treeNodes[p].left = treeNodes[c];
            } else {
                treeNodes[p].right = treeNodes[c];
            }
        }

        return root;
    }
    
    public static void main(String[] args) {
        System.out.println("hello world");
    }
    
}
