package problem901_1000;

public class Problem945_2 {

    public int minIncrementForUnique(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }

        int[] countArr = new int[40001];
        int max = 0;
        for (int num : arr) {
            countArr[num]++;
            max = Math.max(max, num);
        }

        int moveCount = 0;
        for (int i = 0; i < max; i++) {
            if (countArr[i] > 1) {
                moveCount += countArr[i] - 1;
                countArr[i+1] += countArr[i] - 1; // 把较小的多出的几个数都加1。比如1，1，1 其中有两个1都加1变成2，那么2的个数就多了2个。
            }
        }

        // 上面for循环之后，就变成重复的全乎都加到最大的数上了，那么在让最大的数分别+1，+2，+。。。
        return moveCount + countArr[max] * (countArr[max] - 1) / 2;
    }

}
