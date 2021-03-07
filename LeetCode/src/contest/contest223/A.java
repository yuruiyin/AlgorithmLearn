package contest.contest223;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/10
 */
public class A {

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] ansArr = new int[len + 1];
        ansArr[0] = first;
        for (int i = 1; i < len + 1; i++) {
            ansArr[i] = encoded[i - 1] ^ ansArr[i - 1];
        }
        return ansArr;
    }

}
