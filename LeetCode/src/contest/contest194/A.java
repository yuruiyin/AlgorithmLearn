package contest.contest194;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/21
 */
public class A {

    public int xorOperation(int n, int start) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= (start + 2 * i);
        }
        return xor;
    }

}
