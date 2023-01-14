package contest.contest327;

import java.nio.channels.Pipe;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D {

    class Data {
        int leftToRight;
        int pickOld;
        int rightToLeft;
        int putNew;
        int i;

        int rightPickOldTime;

        int leftPutNewTime;
        Data(int leftToRight, int pickOld, int rightToLeft, int putNew, int i) {
            this.leftToRight = leftToRight;
            this.pickOld = pickOld;
            this.rightToLeft = rightToLeft;
            this.putNew = putNew;
            this.i = i;
            this.rightPickOldTime = 0;
            this.leftPutNewTime = 0;
        }
    }

    public int findCrossingTime(int n, int k, int[][] times) {
        // time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi]
        Data[] datas = new Data[k];
        for (int i = 0; i < k; i++) {
            int[] time = times[i];
            datas[i] = new Data(time[0], time[1], time[2], time[3], i);
        }

        PriorityQueue<Data> leftHeap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.leftToRight + o1.rightToLeft == o2.leftToRight + o2.rightToLeft ? (o2.i - o1.i) :
                        (o2.leftToRight + o2.rightToLeft - (o1.leftToRight + o1.rightToLeft));
            }
        });

        PriorityQueue<Data> rightHeap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.leftToRight + o1.rightToLeft == o2.leftToRight + o2.rightToLeft ? (o2.i - o1.i) :
                        (o2.leftToRight + o2.rightToLeft - (o1.leftToRight + o1.rightToLeft));
            }
        });

        for (Data data : datas) {
            leftHeap.add(data);
        }

        PriorityQueue<Data> leftPutNewHeap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.leftPutNewTime - o2.leftPutNewTime;
            }
        });

        PriorityQueue<Data> rightPickOldHeap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.rightPickOldTime - o2.rightPickOldTime;
            }
        });

        //        如果工人 x 到达桥边时，工人 y 正在过桥，那么工人 x 需要在桥边等待。
//        如果没有正在过桥的工人，那么在桥右边等待的工人可以先过桥。如果同时有多个工人在右边等待，那么 效率最低 的工人会先过桥。
//        如果没有正在过桥的工人，且桥右边也没有在等待的工人，同时旧仓库还剩下至少一个箱子需要搬运，
//        此时在桥左边的工人可以过桥。如果同时有多个工人在左边等待，那么 效率最低 的工人会先过桥。

        int curTime = 0;
        int count = 0;
        while (true) {
            if (leftHeap.isEmpty() && rightHeap.isEmpty()) {
                Data leftPutNewTop = leftPutNewHeap.peek();
                Data rightPickOldTop = rightPickOldHeap.peek();
                if (leftPutNewTop == null && rightPickOldTop != null) {
                    rightPickOldHeap.poll();
                    rightHeap.add(rightPickOldTop);
                    curTime = rightPickOldTop.rightPickOldTime;
                } else if (leftPutNewTop != null && rightPickOldTop == null) {
                    leftPutNewHeap.poll();
                    leftHeap.add(leftPutNewTop);
                    curTime = leftPutNewTop.leftPutNewTime;
                } else if (leftPutNewTop != null && rightPickOldTop != null) {
                    if (rightPickOldTop.rightPickOldTime <= leftPutNewTop.leftPutNewTime) {
                        rightPickOldHeap.poll();
                        rightHeap.add(rightPickOldTop);
                        curTime = rightPickOldTop.rightPickOldTime;
                    } else {
                        leftPutNewHeap.poll();
                        leftHeap.add(leftPutNewTop);
                        curTime = leftPutNewTop.leftPutNewTime;
                    }
                }
            }

            while (!rightHeap.isEmpty()) {
                Data right = rightHeap.poll();
                int rightToLeft = right.rightToLeft;
                curTime += rightToLeft;
                count++;
                if (count == n) {
                    return curTime;
                }
                right.leftPutNewTime = curTime + right.putNew;
                leftPutNewHeap.add(right);
                // 当前curTime的时候，putNew和pickOld完需要更新
                while (!leftPutNewHeap.isEmpty()) {
                    Data leftPutNewTop = leftPutNewHeap.peek();
                    if (leftPutNewTop.leftPutNewTime <= curTime) {
                        leftHeap.add(leftPutNewHeap.poll());
                    } else {
                        break;
                    }
                }
                while (!rightPickOldHeap.isEmpty()) {
                    Data rightPickOldTop = rightPickOldHeap.peek();
                    if (rightPickOldTop.rightPickOldTime <= curTime) {
                        rightHeap.add(rightPickOldHeap.poll());
                    } else {
                        break;
                    }
                }
            }

            while (!leftHeap.isEmpty()) {
                if (!rightHeap.isEmpty()) {
                    break;
                }
                Data left = leftHeap.poll();
                int leftToRight = left.leftToRight;
                curTime += leftToRight;
                left.rightPickOldTime = curTime + left.pickOld;
                rightPickOldHeap.add(left);
                // 当前curTime的时候，putNew和pickOld完需要更新
                while (!leftPutNewHeap.isEmpty()) {
                    Data leftPutNewTop = leftPutNewHeap.peek();
                    if (leftPutNewTop.leftPutNewTime <= curTime) {
                        leftHeap.add(leftPutNewHeap.poll());
                    } else {
                        break;
                    }
                }
                while (!rightPickOldHeap.isEmpty()) {
                    Data rightPickOldTop = rightPickOldHeap.peek();
                    if (rightPickOldTop.rightPickOldTime <= curTime) {
                        rightHeap.add(rightPickOldHeap.poll());
                    } else {
                        break;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        // n = 1, k = 3, time = [[1,1,2,1],[1,1,3,1],[1,1,4,1]]
//        System.out.println(new D().findCrossingTime(1, 3, new int[][]{
//                {1,1,2,1}, {1,1,3,1}, {1,1,4,1}
//        }));

        // n = 3, k = 2, time = [[1,9,1,8],[10,10,10,10]]
        System.out.println(new D().findCrossingTime(3, 2, new int[][]{
                {1,9,1,8}, {10,10,10,10}
        }));
    }

}
