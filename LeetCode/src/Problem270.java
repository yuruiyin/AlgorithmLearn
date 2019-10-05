public class Problem270 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private double[] getClosestValue(TreeNode root, double target, double min) {
        double[] res = new double[2];
        int closestValue = root.val;
        double diff = Math.abs(root.val - target);

        if (diff < min) {
            min = diff;
        }

        if (root.left != null) {
            double[] leftRes = getClosestValue(root.left, target, min);
            if (leftRes[0] < min) {
                min = leftRes[0];
                closestValue = (int) leftRes[1];
            }
        }

        if (root.right != null) {
            double[] rightRes = getClosestValue(root.right, target, min);
            if (rightRes[0] < min) {
                min = rightRes[0];
                closestValue = (int) rightRes[1];
            }
        }

        res[0] = min;
        res[1] = closestValue;

        return res;
    }

    public int closestValue(TreeNode root, double target) {
        double[] res = getClosestValue(root, target, Double.MAX_VALUE);

        return (int) res[1];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int res = new Problem270().closestValue(root, 3.714286);
        System.out.println(res);
    }
}
