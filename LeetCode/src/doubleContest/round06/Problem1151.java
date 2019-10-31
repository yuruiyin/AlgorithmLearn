package doubleContest.round06;

public class Problem1151 {

    public int minSwaps(int[] datas) {
        int n = datas.length;
        int oneCount = 0;
        for (int data : datas) {
            if (data == 1) {
                oneCount++;
            }
        }

        if (oneCount == 0) {
            return 0;
        }

        int[] zeroCountArr = new int[n]; // [0, i]中0的个数
        zeroCountArr[0] = datas[0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            zeroCountArr[i] = datas[i] == 0 ? zeroCountArr[i-1] + 1 : zeroCountArr[i-1];
        }

        // 求得[i, i + oneCount) 区间0的个数最小的即是答案
        int min = Integer.MAX_VALUE;
        for (int i = oneCount - 1; i < n; i++) {
            int zeroCount = i == oneCount - 1 ? zeroCountArr[i] : zeroCountArr[i] - zeroCountArr[i - oneCount];
            if (zeroCount < min) {
                min = zeroCount;
            }
        }

        return min;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1151().minSwaps(new int[]{0, 0, 0, 1, 0}));
    }
    
}
