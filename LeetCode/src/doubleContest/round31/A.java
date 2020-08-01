package doubleContest.round31;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/25
 */
public class A {

    public int countOdds(int low, int high) {
        int len = high - low + 1;
        if (len % 2 == 0) {
            return len / 2;
        }

        return len / 2 + low % 2;
    }

}
