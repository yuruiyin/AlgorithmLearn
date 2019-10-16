package interview_tencent.round03;

public class Problem03 {

    public int minSwapsCouples(int[] row) {
        int ans = 0;
        int n = row.length;

        int[] indexArr = new int[n];

        for (int i = 0; i < n; i++) {
            indexArr[row[i]] = i;
        }

        for (int i = 0; i < n; i += 2) {
            if ((row[i] & 1) == 0 && row[i + 1] != row[i] + 1) {
                // 交换
                int swapedIndex = indexArr[row[i] + 1];
                indexArr[row[swapedIndex]] = i + 1;
                indexArr[row[i+1]] = swapedIndex;
                int tmp = row[swapedIndex];
                row[swapedIndex] = row[i + 1];
                row[i + 1] = tmp;

                ans++;
            } else if ((row[i] & 1) == 1 && row[i + 1] != row[i] - 1) {
                // 交换
                int swapedIndex = indexArr[row[i] - 1];
                indexArr[row[swapedIndex]] = i + 1;
                indexArr[row[i+1]] = swapedIndex;
                int tmp = row[swapedIndex];
                row[swapedIndex] = row[i + 1];
                row[i + 1] = tmp;

                ans++;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(new Problem03().minSwapsCouples(new int[]{3, 2, 0, 1}));
        System.out.println(new Problem03().minSwapsCouples(new int[]{1,4,0,5,8,7,6,3,2,9}));
    }

}
