package interview_google.round07;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem536 {

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == ')') {
                List<TreeNode> list = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != null) {
                    list.add(stack.pop());
                }
                stack.pop();
                int size = list.size();
                if (size == 1) {
                    // 叶子节点
                    stack.push(list.get(0));
                } else if (size == 2) {
                    // 只有左子树
                    list.get(1).left = list.get(0);
                    stack.push(list.get(1));
                } else {
                    // 3个数字，有左右子树
                    list.get(2).left = list.get(1);
                    list.get(2).right = list.get(0);
                    stack.push(list.get(2));
                }
            } else if (c == '(') {
                stack.push(null);
            } else {
                int sign = c == '-' ? -1 : 1;
                if (c == '-') {
                    i++;
                }
                int num = 0;
                int j;
                for (j = i; j < len && isNumber(arr[j]) ; j++) {
                    num = num * 10 + (arr[j] - '0');
                }
                stack.push(new TreeNode(sign * num));
                i = j - 1;
            }
        }

        List<TreeNode> nodeList = new ArrayList<>();
        while (!stack.isEmpty()) {
            nodeList.add(stack.pop());
        }

        int size = nodeList.size();
        switch (size) {
            case 0:
                return null;
            case 1:
                return nodeList.get(0);
            case 2:
                nodeList.get(1).left = nodeList.get(0);
                return nodeList.get(1);
            default:
                nodeList.get(2).left = nodeList.get(1);
                nodeList.get(2).right = nodeList.get(0);
                return nodeList.get(2);
        }
    }
    
    public static void main(String[] args) {

    }
    
}
