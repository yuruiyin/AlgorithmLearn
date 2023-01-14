package doubleContest.round094;

public class C {

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int targetCount = uniqueCnt1 + uniqueCnt2;
        long gcd = gcd(divisor1, divisor2);
        long lcm = (long) divisor1 * divisor2 / gcd;

        int l = 1;
        int r = (int) (2e9 + 2);
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int count = mid - (mid < lcm ? 0 : mid / (int) lcm);
            int count1 = mid - mid / divisor1;
            int count2 = mid - mid / divisor2;
            if (count >= targetCount && count1 >= uniqueCnt1 && count2 >= uniqueCnt2) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new C().minimizeSet(2, 7, 1, 3));
        System.out.println(new C().minimizeSet(2, 4, 8, 2));
    }

}
