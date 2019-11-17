package contest.contest132;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem1028 {

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public TreeNode recoverFromPreorder(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;

        List<TreeNode>[] levelNodeList = new ArrayList[1001];
        for (int i = 0; i < 1001; i++) {
            levelNodeList[i] = new ArrayList<>();
        }

        int lineCount = 0;
        TreeNode root = null;
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (isNumber(c)) {
                int nodeValue = 0;
                int j;
                for (j = i; j < len && isNumber(arr[j]); j++) {
                    nodeValue = nodeValue * 10 + arr[j] - '0';
                }

                if (lineCount == 0) {
                    root = new TreeNode(nodeValue);
                    levelNodeList[lineCount].add(root);
                } else {
                    List<TreeNode> nodeList = levelNodeList[lineCount-1];
                    TreeNode node = nodeList.get(nodeList.size() - 1);
                    TreeNode wantAddNode = new TreeNode(nodeValue);
                    if (node.left == null) {
                        node.left = wantAddNode;
                    } else {
                        node.right = wantAddNode;
                    }
                    levelNodeList[lineCount].add(wantAddNode);
                }
                lineCount = 0;
                i = j-1;
            } else {
                // -
                lineCount++;
            }
        }

        return root;
    }
    
    public static void main(String[] args) {
        
    }
    
}
