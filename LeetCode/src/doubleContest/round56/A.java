package doubleContest.round56;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/10
 */
public class A {

    public int countTriples(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int c = i * i + j * j;
                int sqrt = (int) Math.sqrt(c);
                if (sqrt * sqrt == c && c <= n * n) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
