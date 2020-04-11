package problem601_700;

/**
 * Problem693_1
 *
 * @author: yry
 * @date: 2020/4/11
 */
public class Problem693_1 {

    public boolean hasAlternatingBits(int n) {
        n = (n ^ (n >>> 1));
        return (n & (n + 1)) == 0;
    }

}
