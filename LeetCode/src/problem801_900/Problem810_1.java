package problem801_900;

// 数学方法
public class Problem810_1 {

    // 简单证明：反证法：
    // 设有四个数x1,x2,x3,x4, 已知(x1 xor x2 xor x3 xor x4) != 0那么反证法就是删除所有的元素，剩下三个数的异或都是0，即：
    // 删除x1：x2 xor x3 xor x4 = 0
    // 删除x2：x1 xor x3 xor x4 = 0
    // 删除x3：x1 xor x2 xor x4 = 0
    // 删除x4：x1 xor x2 xor x3 = 0
    // 合并上面，即 可得 x1 xor x2 xor x3 xor x4 == 0，这与已知条件矛盾。
    // 同理，扩展到n（n为偶数）个数也是一样，也就是说上面会变成奇数个x1 xor 奇数个 x2 ... xor 奇数个xn。而奇数个xn的xor就等于xn本身。
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }

}
