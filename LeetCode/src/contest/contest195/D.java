package contest.contest195;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/30
 */
public class D {

    class Data {
        int index;
        int x;
        int y;
        Data(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    private int handle(PriorityQueue<Data> addHeap, PriorityQueue<Data> minusHeap) {
        if (addHeap.size() <= 1) {
            addHeap.clear();
            minusHeap.clear();
            return Integer.MIN_VALUE;
        }

        Data maxAddData = addHeap.poll();
        Data maxMinusData = minusHeap.poll();
        int res = 0;
        if (maxAddData.index != maxMinusData.index) {
            res = maxAddData.x + maxAddData.y + (maxMinusData.y - maxMinusData.x);
        } else {
            Data maxAddData1 = addHeap.poll();
            Data maxMinusData1 = minusHeap.poll();
            int value1 = maxAddData.x + maxAddData.y + (maxMinusData1.y - maxMinusData1.x);
            int value2 = maxAddData1.x + maxAddData1.y + (maxMinusData.y - maxMinusData.x);
            res = Math.max(value1, value2);
        }

        addHeap.clear();
        minusHeap.clear();
        return res;
    }

    public int findMaxValueOfEquation(int[][] points, int k) {
        int len = points.length;
        int ansMax = Integer.MIN_VALUE;
        PriorityQueue<Data> addHeap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.x + o2.y - (o1.x + o1.y);
            }
        });

        PriorityQueue<Data> minusHeap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.y - o2.x - (o1.y - o1.x);
            }
        });

        Data data1 = new Data(points[0][0], points[0][1], 0);
        addHeap.offer(data1);
        minusHeap.offer(data1);
        int minX = data1.x;

        for (int i = 1; i < len; i++) {
            int[] point = points[i];
            int curX = point[0];
            int curY = point[1];
            Data data = new Data(curX, curY, i);
            if (curX - minX <= k) {
                addHeap.offer(data);
                minusHeap.offer(data);
            } else {
                ansMax = Math.max(ansMax, handle(addHeap, minusHeap));
                minX = curX;
                addHeap.offer(data);
                minusHeap.add(data);
            }
        }

        ansMax = Math.max(ansMax, handle(addHeap, minusHeap));
        return ansMax;
    }

}
