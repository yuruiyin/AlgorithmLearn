package problem701_800;

public class Problem765 {

    public int minSwapsCouples(int[] row) {
        int ans = 0;
        int n = row.length;
        int[] indexArr = new int[n];

        for (int i = 0; i < n; i++) {
            indexArr[row[i]] = i;
        }

        int next = 0;
        for (int i = 0; i < n; i += 2) {
            next = (row[i] & 1) == 0 ? row[i] + 1 : row[i] - 1;
            if (next == row[i + 1]) {
                continue;
            }

            int swapedIndex = indexArr[next];
            indexArr[row[i+1]] = swapedIndex;
            row[swapedIndex] = row[i + 1];
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem765().minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(new Problem765().minSwapsCouples(new int[]{3, 2, 0, 1}));
        System.out.println(new Problem765().minSwapsCouples(new int[]{1,4,0,5,8,7,6,3,2,9}));
    }


}
