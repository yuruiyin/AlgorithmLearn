package problem301_400;

public class Problem338_1 {

    // 奇数的1的个数等于前面一个数的1的个数+1 ，如101 是在100基础上加上一个1
    // 偶数的1的个数等于除以2（右移1位）的那个数的1的个数。
    public int[] countBits(int num) {
        int[] ansArr = new int[num+1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                ansArr[i] = ansArr[i-1] + 1;
            } else {
                ansArr[i] = ansArr[i/2];
            }
        }

        return ansArr;
    }

}
