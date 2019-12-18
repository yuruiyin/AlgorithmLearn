package problem201_300;

public class Problem255 {

    public boolean verifyPreorder(int[] preorder) {
        // 遍历每个元素，右侧发现比这个元素大之后，后面必须都要比这个元素大
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            boolean isBeginBigger = false;
            for (int j = i+1; j < len; j++) {
                if (isBeginBigger && preorder[j] < preorder[i]) {
                    return false;
                }
                if (preorder[j] > preorder[i]) {
                    isBeginBigger = true;
                }
            }
        }

        return true;
    }

}
