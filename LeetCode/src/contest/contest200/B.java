package contest.contest200;

import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/2
 */
public class B {

    public int getWinner(int[] arr, int k) {
        int len = arr.length;

        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        if (k >= len) {
            return max;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int num : arr) {
            queue.add(num);
        }

        int count = 0;
        int lastWin = -1;
        while (!queue.isEmpty()) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            int win = Math.max(num1, num2);
            if (num1 > num2) {
                queue.addFirst(num1);
                queue.addLast(num2);
            } else {
                queue.addFirst(num2);
                queue.addLast(num1);
            }

            if (lastWin == -1 || lastWin == win) {
                count++;
            } else {
                count = 1;
            }

            lastWin = win;
            if (count == k) {
                break;
            }
        }

        return lastWin;
    }

}
