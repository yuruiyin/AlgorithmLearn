package contest158;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Problem02 {

    class Data {
        int x;
        int y;
        Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class CustomCmpX implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        }
    }

    class CustomCmpY implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            if (o1.y != o2.y) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        }
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Data> queenList = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            Data data = new Data(queens[i][0], queens[i][1]);
            queenList.add(data);
        }

        queenList.sort(new CustomCmpX());

        // 处理行
        int minRightY = Integer.MAX_VALUE;
        int minLeftY = Integer.MAX_VALUE;
        int resRightIndex = -1;
        int resLeftIndex = -1;
        for (int i = 0; i < queenList.size(); i++) {
            Data data = queenList.get(i);
            if (data.x != king[0]) {
                continue;
            }

            int diff = data.y - king[1];
            if (diff > 0 && diff < minRightY) {
                minRightY = diff;
                resRightIndex = i;
            }

            if (diff < 0 && -diff < minLeftY) {
                minLeftY = -diff;
                resLeftIndex = i;
            }
        }

        if (resLeftIndex != -1) {
            List<Integer> list = new ArrayList<>();
            list.add(queenList.get(resLeftIndex).x);
            list.add(queenList.get(resLeftIndex).y);
            ansList.add(list);
        }

        if (resRightIndex != -1) {
            List<Integer> list = new ArrayList<>();
            list.add(queenList.get(resRightIndex).x);
            list.add(queenList.get(resRightIndex).y);
            ansList.add(list);
        }

        queenList.sort(new CustomCmpY());

        // 处理行
        int minBottomY = Integer.MAX_VALUE;
        int minTopY = Integer.MAX_VALUE;
        int resBottomIndex = -1;
        int resTopIndex = -1;
        for (int i = 0; i < queenList.size(); i++) {
            Data data = queenList.get(i);
            if (data.y != king[1]) {
                continue;
            }

            int diff = data.x - king[0];
            if (diff > 0 && diff < minBottomY) {
                minBottomY = diff;
                resBottomIndex = i;
            }

            if (diff < 0 && -diff < minTopY) {
                minTopY = -diff;
                resTopIndex = i;
            }
        }

        if (resTopIndex != -1) {
            List<Integer> list = new ArrayList<>();
            list.add(queenList.get(resTopIndex).x);
            list.add(queenList.get(resTopIndex).y);
            ansList.add(list);
        }

        if (resBottomIndex != -1) {
            List<Integer> list = new ArrayList<>();
            list.add(queenList.get(resBottomIndex).x);
            list.add(queenList.get(resBottomIndex).y);
            ansList.add(list);
        }

        // 处理对角线
        int minTopRightDiff = Integer.MAX_VALUE;
        int minTopLeftDiff = Integer.MAX_VALUE;
        int minBottomLeftDiff = Integer.MAX_VALUE;
        int minBottomRightDiff = Integer.MAX_VALUE;
        int resTopRightIndex = -1;
        int resTopLeftIndex = -1;
        int resBottomLeftIndex = -1;
        int resBottomRightIndex = -1;
        for (int i = 0; i < queenList.size(); i++) {
            Data data = queenList.get(i);
            int xDiff = data.x - king[0];
            int yDiff = data.y - king[1];
            if (Math.abs(xDiff) != Math.abs(yDiff)) {
                continue;
            }

            if (xDiff > 0 && yDiff > 0) {
                // 右下
                if (xDiff < minBottomRightDiff) {
                    minBottomRightDiff = xDiff;
                    resBottomRightIndex = i;
                }
            } else if (xDiff < 0 && yDiff > 0) {
                // 右上
                if (yDiff < minTopRightDiff) {
                    minTopRightDiff = yDiff;
                    resTopRightIndex = i;
                }
            } else if (xDiff < 0 && yDiff < 0) {
                // 左上
                if (-xDiff < minTopLeftDiff) {
                    minTopLeftDiff = -xDiff;
                    resTopLeftIndex = i;
                }
            } else {
                if (xDiff < minBottomLeftDiff) {
                    minBottomLeftDiff = xDiff;
                    resBottomLeftIndex = i;
                }
            }
        }

        if (resBottomRightIndex != -1) {
            List<Integer> list = new ArrayList<>();
            list.add(queenList.get(resBottomRightIndex).x);
            list.add(queenList.get(resBottomRightIndex).y);
            ansList.add(list);
        }

        if (resBottomLeftIndex != -1) {
            List<Integer> list = new ArrayList<>();
            list.add(queenList.get(resBottomLeftIndex).x);
            list.add(queenList.get(resBottomLeftIndex).y);
            ansList.add(list);
        }

        if (resTopLeftIndex != -1) {
            List<Integer> list = new ArrayList<>();
            list.add(queenList.get(resTopLeftIndex).x);
            list.add(queenList.get(resTopLeftIndex).y);
            ansList.add(list);
        }

        if (resTopRightIndex != -1) {
            List<Integer> list = new ArrayList<>();
            list.add(queenList.get(resTopRightIndex).x);
            list.add(queenList.get(resTopRightIndex).y);
            ansList.add(list);
        }

        return ansList;

    }
    
    public static void main(String[] args) {
//        int[][] queues = new int[][] {
//                {0,1},
//                {1,0},
//                {4,0},
//                {0,4},
//                {3,3},
//                {2,4}
//        };
//
//        int[] king = new int[]{0,0};

        int[][] queues = new int[][] {
                {0,0},
                {1,1},
                {2,2},
                {3,4},
                {3,5},
                {4,4},
                {4,5}
        };

        int[] king = new int[]{3,3};

        List<List<Integer>> ansList = new Problem02().queensAttacktheKing(queues, king);
        
        for (List<Integer> list : ansList) {
            for (Integer num : list) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
    
}
