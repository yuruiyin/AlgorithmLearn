package problem201_300;

public class Problem255_1 {

    // 用单调栈的方式，递减栈，当碰到一个数比栈顶元素大的时候，说明从左子树到了右子树。
    // 此时要删掉左子树的所有节点，并且保留子树的根为最小值，此时遍历的所有右子树的节点都必须大于这个根，否则非法
    public boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;
        int[] stack = new int[len];
        int top = -1;
        int min = Integer.MIN_VALUE;

        for (int value : preorder) {
            if (value < min) {
                return false;
            }

            while (top > -1 && value > stack[top]) {
                min = stack[top];
                top--;
            }

            stack[++top] = value;
        }

        return true;
    }

}
