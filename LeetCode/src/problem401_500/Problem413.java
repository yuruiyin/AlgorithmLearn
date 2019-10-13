package problem401_500;

public class Problem413 {

    public int numberOfArithmeticSlices(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return 0;
        }

        int diffLen = len - 1;
        int[] diff = new int[diffLen];

        for (int i = 1; i < len; i++) {
            diff[i - 1] = arr[i] - arr[i - 1];
        }

        // 计算连续相同的diff值，然后每一块连续相同的diff数列会生成n(n-1)/2种的等差数列
        int sameValueCount = 1;
        int ansCount = 0;
        for (int i = 1; i < diffLen; i++) {
            if (diff[i] == diff[i - 1]) {
                sameValueCount++;
            } else {
                ansCount += (sameValueCount - 1) * sameValueCount / 2;
                sameValueCount = 1;
            }
        }

        if (sameValueCount != 1) {
            ansCount += (sameValueCount - 1) * sameValueCount / 2;
        }

        return ansCount;
    }

    public static void main(String[] args) {
        System.out.println(new Problem413().numberOfArithmeticSlices(new int[]{1,2,3,4})); //3
    }
}
