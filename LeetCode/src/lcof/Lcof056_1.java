package lcof;

public class Lcof056_1 {

    // 思路：
    // 1. 因为只有两个元素只出现一次，因此可以先将所有数异或，得到这两个元素的异或值，设为A^B
    // 2. 因为这两个元素值是不相等的，因此A^B一定不为0，也就是说必定有一位上为1，而能通过异或得到这个1，也就是A和B两个值在那位上有一个是0，有一个是1.
    //    因此，我们的目标就是找到那个1，可以使用mask = xor & (-xor)，是-xor，也就是取反加1，就能得到xor值的最低位为1的mask。
    // 3. 得到以上mask之后，我们遍历整个数组，如果数组中的元素与mask与之后等于0，说明这些元素一定有一个是A或者B，其它元素都成双成对的。然后将这写元素
    //    异或起来就会得到A或者B。反之，就会得到B或者A。最后就得到了这两个值
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int mask = xor & (-xor);
        int first = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                first ^= num;
            }
        }

        return new int[]{first, xor ^ first};
    }

}
