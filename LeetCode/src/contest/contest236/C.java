package contest.contest236;

import java.util.Collections;
import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/11
 */
public class C {

    public int minSideJumps(int[] obstacles) {
        LinkedList<Integer>[] obIndexListArr = new LinkedList[3];

        for (int i = 0; i < 3; i++) {
            obIndexListArr[i] = new LinkedList<>();
        }

        int len = obstacles.length;
        for (int i = 0; i < len; i++) {
            int ob = obstacles[i];
            if (ob == 0) {
                continue;
            }

            int idx = ob - 1;
            obIndexListArr[idx].offer(i);
        }

        for (int i = 0; i < 3; i++) {
            LinkedList<Integer> obIdxList = obIndexListArr[i];
            Collections.sort(obIdxList);
        }

        int curPos = 1;
        int ans = 0;

        while (true) {
            LinkedList<Integer> obIdxList = obIndexListArr[curPos];
            if (obIdxList.isEmpty()) {
                return ans;
            }

            int curX = obIdxList.peek() - 1;
            for (int i = 0; i < 3; i++) {
                if (i == curPos) {
                    continue;
                }

                LinkedList<Integer> tmpList = obIndexListArr[i];
                while (!tmpList.isEmpty() && tmpList.peek() < curX) {
                    tmpList.poll();
                }
            }

            int maxX = curX;
            int maxPos = -1;
            for (int i = 0; i < 3; i++) {
                LinkedList<Integer> tmpList = obIndexListArr[i];
                if (tmpList.isEmpty()) {
                    maxPos = i;
                    break;
                }
                int first = tmpList.peek();
                if (first > maxX) {
                    maxX = first;
                    maxPos = i;
                }
            }

            for (int i = 0; i < 3; i++) {
                LinkedList<Integer> tmpList = obIndexListArr[i];
                if (tmpList.isEmpty()) {
                    continue;
                }

                int first = tmpList.peek();
                if (first == curX) {
                    tmpList.poll();
                }
            }

            curPos = maxPos;
            ans++;
        }
    }

    public static void main(String[] args) {
//        System.out.println("1");
        System.out.println(new C().minSideJumps(new int[]{0,1,2,3,0}));
    }

}
