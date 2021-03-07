package doubleContest.round42;

import java.util.LinkedList;
import java.util.Stack;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/26
 */
public class A {

    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int num : students) {
            queue.addLast(num);
        }

        int len = sandwiches.length;
        int idx = 0;

        while (idx < len) {
            int front = queue.getFirst();
            if (front == sandwiches[idx]) {
                queue.removeFirst();
                idx++;
            } else {
                boolean hasSame = false;
                for (int num : queue) {
                    if (num == sandwiches[idx]) {
                        hasSame = true;
                        break;
                    }
                }

                if (!hasSame) {
                    break;
                }

                queue.removeFirst();
                queue.addLast(front);
            }
        }

        return queue.size();
    }

}
