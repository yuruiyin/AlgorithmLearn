/**
 * LintCode001
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode001 {

    public int aplusb(int a, int b) {
        int ans = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int curBitA = a & 1;
            int curBitB = b & 1;
            ans |= (curBitA ^ curBitB ^ carry) << i;
            carry = (curBitA & curBitB) | (carry & (curBitA | curBitB));
            a >>>= 1;
            b >>>= 1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.print(new LintCode001().aplusb(1000000000,1000000000));
    }

}
