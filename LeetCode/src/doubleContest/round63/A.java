package doubleContest.round63;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/16
 */
public class A {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int len = seats.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.abs(students[i] - seats[i]);
        }
        return ans;
    }

}
