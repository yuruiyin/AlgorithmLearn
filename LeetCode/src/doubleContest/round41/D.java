package doubleContest.round41;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/12
 */
public class D {

    private int getCount(int[][] boxes, int from, int to) {
        if (from > to) {
            return 0;
        }
        int prePort = boxes[from][0];
        int count = 1;

        for (int j = from + 1; j <= to; j++) {
            int[] box = boxes[j];
            int port = box[0];
            if (port == prePort) {
                continue;
            }

            prePort = port;

            count++;
        }

        return count;
    }

    private int getToIdx(int[][] boxes, int from, int len, int maxBoxes, int maxWeight) {
        int curBoxCount = 0;
        int curWeight = 0;
        int to = from;
        for (int j = from; j < len; j++) {
            int[] box = boxes[j];
            int weight = box[1];
            if (curBoxCount + 1 <= maxBoxes && curWeight + weight <= maxWeight) {
                to = j;
                curBoxCount++;
                curWeight += weight;
            } else {
                break;
            }
        }

        return to;
    }

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int ans = 0;
        int len = boxes.length;
        for (int i = 0; i < len; ) {
            int to = getToIdx(boxes, i, len, maxBoxes, maxWeight);

            // 可能需要回退
            if (to < len - 1 && boxes[to + 1][0] == boxes[to][0]) {
                int lastFrom1 = to;
                for (int j = to - 1; j >= i; j--) {
                    int[] box = boxes[j];
                    int port = box[0];
                    if (port != boxes[to][0]) {
                        break;
                    }
                    lastFrom1 = j;
                }

                int to1 = getToIdx(boxes, to + 1, len, maxBoxes, maxWeight);
//                int count1 = getCount(boxes, to + 1, to1);
                int to2 = getToIdx(boxes, lastFrom1, len, maxBoxes, maxWeight);
//                int count2 = getCount(boxes, lastFrom1, to2);

                if (to1 == to2 && lastFrom1 != i) {
                    // [lastFrom1, to] 应该归到后面
                    int count = getCount(boxes, i, lastFrom1 - 1);
                    ans += count;
                    ans++;
                    i = lastFrom1;
                    continue;
                }

            }

            int count = getCount(boxes, i, to);
            ans += count;
            ans++;
            i = to + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().boxDelivering(new int[][]{
                {1, 1},
                {2, 1},
                {1, 1}
        }, 2 ,3 ,3));
    }

}
