package contest.contest083;

public class Problem829 {

    public int consecutiveNumbersSum(int n) {
        int ans = 0;

        if (n == 1) {
            return 1;
        }

        if ((n & 1) == 1) {
            // 奇数一定能拆成 n/2 + (n/2 + 1)
            ans++;
        }

        // 连续的整数和有一个特点，就是要么是奇数的倍数，要么是.5的倍数，比如15 = 7.5 * 2,也就是2*n是奇数的倍数，如30是15的倍数

        // 先求得所有合法（10 / 5 == 2, 2 左边只能有一个数，小于 5 / 2 == 2个数,因此不合法）的奇数因子
        for (int i = 1; i <= n/i ; i ++) {
            if (n % i == 0) {
                int value = n / i;
                if ((i & 1) == 1) {
                    if (n / i > i / 2) {
                        ans++;
                    }
                }

                if (value != i && (value & 1) == 1) {
                    // 比如 i=3，n=15的情况
                    if (n / value > value / 2) {
                        ans++;
                    }
                }
            }
        }

        //求得2n中合法的奇数因子
        n *= 2;
        for (int i = 3; i <= n/i; i ++) {
            if (n % i == 0) {
                int value = n / i;
                if ((i & 1) == 1) {
                    if (i > value) {
                        ans++;
                    }
                }

                if (value != i && (value & 1) == 1) {
                    if (value > i) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem829().consecutiveNumbersSum(5)); // 2
        System.out.println(new Problem829().consecutiveNumbersSum(9)); // 3
        System.out.println(new Problem829().consecutiveNumbersSum(15));// 4
        System.out.println(new Problem829().consecutiveNumbersSum(6)); // 2
    }
    
}
