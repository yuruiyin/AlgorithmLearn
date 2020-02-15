package lcof;

public class Lcof033 {

    private boolean isValid(int[] postorder, int start, int end) {
        if (end - start <= 1) {
            return true;
        }

        int rootVal = postorder[end]; // 后序遍历最后一个数就是根
        // 判断当前子树代表的后序遍历数组，是否存左边一半小于rootVal，右边一半大于rootVal，
        // 或者只有左子树（值都小于rootVal），或者只有右子树（值都大于rootVal）

        int firstBiggerIndex = -1;
        for (int i = start; i < end; i++) {
            if (postorder[i] > rootVal) {
                firstBiggerIndex = i;
                break;
            }
        }

        if (firstBiggerIndex == -1) {
            // 所有的数都小于rootVal，也就是认为只有左子树
            return isValid(postorder, start, end - 1);
        }

        // 发现一个比rootVal大，那么后面就一定都要比rootVal大，因为他是右子树
        for (int i = firstBiggerIndex + 1; i < end; i++) {
            if (postorder[i] < rootVal) {
                return false;
            }
        }

        if (firstBiggerIndex == start) {
            // 所有的数都大于rootVal，也就是认为只有右子树
            return isValid(postorder, start, end - 1);
        }

        return isValid(postorder, start, firstBiggerIndex - 1) && isValid(postorder, firstBiggerIndex, end - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        // 递归求解
        return isValid(postorder, 0, postorder.length - 1);
    }

}
