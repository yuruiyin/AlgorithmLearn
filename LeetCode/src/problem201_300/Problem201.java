package problem201_300;

public class Problem201 {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        // 看看[m,n]里头包含的最大的是2的多少次方
        int target = -1;
        for (int i = 0; i < 32; i++) {
            int powValue = 1 << i;
            if (powValue >= m && powValue <= n) {
                target = i;
            }
        }

        // 将m和n都右移target位
        if (target != -1) {
            m >>>= target;
            n >>>= target;
        }

        if (m == 0 || n == 0) {
            return 0;
        }

        int ans = m;
        for (int i = m + 1; i <= n && i >= 0; i++) {
            ans &= i;
        }

        if (target != -1) {
            ans = ans << target;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem201().rangeBitwiseAnd(2147483646, 2147483647));
    }

}
