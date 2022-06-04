package doubleContest.round072;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class C {

    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2L == 1L) {
            return new ArrayList<>();
        }

        LinkedList<Long> queue = new LinkedList<>();
        for (long i = 2; finalSum > 0 ;i+=2) {
            long diff = finalSum - i;
            if (diff < 0) {
                Long last = queue.pollLast();
                if (last != null) {
                    queue.addLast(last + finalSum);
                }
                break;
            } else {
                queue.add(i);
                finalSum -= i;
            }
        }
        return queue;
    }

}
