package doubleContest.round117;

public class A {

    public int distributeCandies(int n, int limit) {
        int each = n / 3;
        int mod = n % 3;
        int max = mod != 0 ? each + 1 : each;
        if (max > limit) {
            return 0;
        }

        int firstMax = Math.min(n, limit);
        int ans = 0;
        for (int first = firstMax; first >= 0; first--) {
            int left = n - first;
            if (left > 2 * limit) {
                break;
            }
            if (left <= limit) {
                ans += (left + 1);
            } else {
                int left1 = left - limit;
                ans += (limit - left1 + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
