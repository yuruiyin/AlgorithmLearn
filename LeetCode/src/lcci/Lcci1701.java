package lcci;

/**
 * Lcci1701
 *
 * @author: yry
 * @date: 2020/4/16
 */
public class Lcci1701 {

    public int add(int a, int b) {
        while (a != 0) {
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }

}
