package problem1001_1100;

public class Problem1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int len = customers.length;
        int[] sumArr = new int[len];

        sumArr[0] = grumpy[0] == 1 ? customers[0] : 0;

        for (int i = 1; i < len; i++) {
            sumArr[i] = grumpy[i] == 1 ? (sumArr[i-1] + customers[i]) : sumArr[i-1];
        }

        int max = sumArr[x - 1];
        int from = 0;
        int to = x - 1;
        for (int i = 1; i < len - x + 1; i++) {
            int sum = sumArr[i+x-1] - sumArr[i-1];
            if (sum > max) {
                max = sum;
                from = i;
                to = i + x - 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (i >= from && i <= to) {
                grumpy[i] = 0;
            }

            if (grumpy[i] == 0) {
                ans += customers[i];
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
