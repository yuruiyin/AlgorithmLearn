package contest.contest264;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/24
 */
public class B {

    private boolean isOk(int n) {
        int[] countArr = new int[10];
        while (n > 0) {
            countArr[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (countArr[i] == 0) {
                continue;
            }

            if (countArr[i] != i) {
                return false;
            }
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ;i++) {
            if (isOk(i)) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new B().nextBeautifulNumber(1000000));
//        System.out.println(new B().nextBeautifulNumber(10000000));
        System.out.println(new B().nextBeautifulNumber(100000000));
//        System.out.println(new B().nextBeautifulNumber(1000000000));
    }

}
