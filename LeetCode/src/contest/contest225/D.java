package contest.contest225;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/24
 */
public class D {

    public int minimumBoxes(int n) {
        if (n <= 3) {
            return n;
        }

        int sum = 0;
        int ans = 3;
        int diff = 0;
        int sum1 = 0;
        for (int i = 1; ;i++) {
            sum += sum1 + i;
            sum1 += i;
            ans = i;
            if (sum >= n) {
                diff = sum - n;
                break;
            }
        }

        return sum1 - diff;
    }

    public static void main(String[] args) {
//        System.out.println(new D().minimumBoxes(4));
        System.out.println(new D().minimumBoxes(10));
    }

}
