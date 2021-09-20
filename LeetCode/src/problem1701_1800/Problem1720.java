package problem1701_1800;

/**
 * Problem1720
 *
 * @author: yry
 * @date: 2021/5/6
 */
public class Problem1720 {

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] ansArr = new int[len + 1];
        ansArr[0] = first;
        for (int i = 0; i < len; i++) {
            ansArr[i + 1] = encoded[i] ^ ansArr[i];
        }

        return ansArr;
    }

}
