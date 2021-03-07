package dianfeng_contest.S202;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/20
 */
public class A {

    /**
     *
     * @param a long长整型 木棒的长度
     * @return int整型
     */
    public int stick (long a) {
        // write code here
        long first = 1;
        long second = 1;
        long sum = 2;
        int i;
        for (i = 3; ;i++) {
            long oldSecond = second;
            second = first + second;
            first = oldSecond;
            sum += second;
            if (sum > a) {
                i--;
                break;
            }
        }

        return i;
    }

}
