package problem601_700;

/**
 * Problem693
 *
 * @author: yry
 * @date: 2020/4/11
 */
public class Problem693 {

    public boolean hasAlternatingBits(int n) {
        while (n > 0) {
            if ((n & 1) == ((n >>> 1) & 1)) {
                return false;
            }
            n >>>= 1;
        }
        return true;
    }

}
