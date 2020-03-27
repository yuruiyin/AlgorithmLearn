package problem601_700;

/**
 * Problem660
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class Problem660 {

    // 移除9刚好变成9进制
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }

}
