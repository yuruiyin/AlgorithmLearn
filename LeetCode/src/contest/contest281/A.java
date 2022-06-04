package contest.contest281;

public class A {

    private boolean isOk(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }

    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            if (isOk(i)) {
                ans++;
            }
        }
        return ans;
    }

}
