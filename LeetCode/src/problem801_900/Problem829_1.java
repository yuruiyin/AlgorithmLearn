package problem801_900;

public class Problem829_1 {

    /**
     * 思路 比如1 + 2 + 3 + 4 + 5 = 1 * 5 + (1 + 2 + 3 + 4)
     * 那么让n不断-1, -1-2, -1-2-3, -1-2-3-4 ，如果减i次过后的值能被(i+1)整除，说明找到了一个答案
     */
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int i = 1; i <= n; n -= i, i++) {
            ans += (n % i == 0 ? 1 : 0);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem829_1().consecutiveNumbersSum(15));
    }
    
}
