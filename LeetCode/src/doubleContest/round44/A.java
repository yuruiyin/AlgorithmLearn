package doubleContest.round44;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/23
 */
public class A {

    public int largestAltitude(int[] gain) {
        int max = 0;
        int pre = 0;
        for (int i = 0; i < gain.length; i++) {
            pre = gain[i] + pre;
            max = Math.max(max, pre);
        }

        return max;
    }

}
