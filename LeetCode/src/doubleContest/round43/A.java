package doubleContest.round43;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/9
 */
public class A {

    public int totalMoney(int n) {
        int ans = 0;
        int value = 1;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                value = i / 7 + 1;
            }
            ans += value;
            value++;
        }
        return ans;
    }

}
