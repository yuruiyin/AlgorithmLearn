package problem1101_1200;

public class Problem1124 {

    public int longestWPI(int[] hours) {
        // 大于8小时变成1，否则是-1,然后求前缀和，
        int n = hours.length;
        int[] prevSum = new int[n+1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            prevSum[i+1] = prevSum[i] + (hours[i] > 8 ? 1 : -1);
            for (int j = 0; j <= i-max; j++) {
                if (prevSum[i+1] > prevSum[j]) {
                    // 说明j到i之间1的个数比-1的个数多
                    int len = i - j + 1;
                    if (len > max) {
                        max = len;
                    }
                    break;
                }
            }
        }

        return max;
    }
    
    public static void main(String[] args) {

    }
    
}
