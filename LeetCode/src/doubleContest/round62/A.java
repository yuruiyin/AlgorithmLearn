package doubleContest.round62;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/2
 */
public class A {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (len != m * n) {
            return new int[][]{};
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < len; i++) {
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
