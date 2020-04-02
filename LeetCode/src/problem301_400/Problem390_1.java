package problem301_400;

/**
 * Problem390_1
 *
 * @author: yry
 * @date: 2020/4/1
 */
public class Problem390_1 {

    public int lastRemaining(int n) {
        int count = n;
        int first = 1;
        int diff = 1;
        boolean isFromLeft = true;
        while (count > 1) {
            if (isFromLeft) {
                first += diff;
            } else {
                if ((count & 1) == 1) {
                    first += diff;
                }
            }

            count >>>= 1;
            diff <<= 1;
            isFromLeft = !isFromLeft;
        }

        return first;
    }

}
