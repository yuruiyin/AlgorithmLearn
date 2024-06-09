package doubleContest.round132;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class B {

    public int findWinningPlayer(int[] skills, int k) {
        int len = skills.length;
        LinkedList<Integer> queue = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < len; i++) {
            queue.addLast(i);
            max = Math.max(max, skills[i]);
        }

        int preIdx = -1;
        int preCount = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int firstIdx = queue.pollFirst();
            int secondIdx = queue.pollFirst();
            int tmpMaxIdx = 0;
            if (skills[firstIdx] > skills[secondIdx]) {
                tmpMaxIdx = firstIdx;
                queue.addFirst(firstIdx);
                queue.addLast(secondIdx);
            } else {
                tmpMaxIdx = secondIdx;
                queue.addFirst(secondIdx);
                queue.addLast(firstIdx);
            }
            if (skills[tmpMaxIdx] == max) {
                return tmpMaxIdx;
            }

            if (preIdx == -1) {
                preIdx = tmpMaxIdx;
                preCount++;
            } else {
                if (tmpMaxIdx == preIdx) {
                    preCount++;
                } else {
                    preIdx = tmpMaxIdx;
                    preCount = 1;

                }
            }
            if (preCount == k) {
                return tmpMaxIdx;
            }
        }
        return -1;
    }

}
