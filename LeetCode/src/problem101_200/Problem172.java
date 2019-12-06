package problem101_200;

public class Problem172 {

    public int trailingZeroes(int n) {
        int ansZeroCount = 0;

        // 只要计算有多少对2和5的组合即可。而5的个数又比2的少，因此只要计算有多少个5即可，但这里要注意25 = 5 * 5包括两个5，比如25 * 4 = 100会多出两个0.
        while (n >= 5) {
            ansZeroCount += n / 5;
            n /= 5;
        }

        return ansZeroCount;
    }

}
