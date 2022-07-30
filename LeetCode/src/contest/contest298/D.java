package contest.contest298;

import java.util.*;

public class D {

    class Data {
        double h;
        double w;
        double p;
        Data(int h, int w, int p) {
            this.h = h;
            this.w = w;
            this.p = p;
        }
    }

    private List<Data>[] listArr;
    private int maxH;
    private int maxW;
    private long[] memo;

    private long rec(int fromH) {
        if (fromH == maxH + 1) {
            return 0;
        }

        if (memo[fromH] != -1) {
            return memo[fromH];
        }

        long ansMax = 0;
        for (int h = 1; fromH + h - 1 <= maxH; h++) {
            //当前切的高度为h
            TreeSet<Data> totalList = new TreeSet<>(new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return Double.compare(o2.p / o2.w, o1.p / o1.w);
                }
            });

            for (int i = h; i >= 1; i--) {
                if (listArr[i] == null) {
                    continue;
                }
                totalList.addAll(listArr[i]);
            }

            if (totalList.isEmpty()) {
                continue;
            }

            int sumW = 0;
            long sumP = 0;

            for (Data data : totalList) {
                while (sumW + data.w <= maxW) {
                    sumW += data.w;
                    sumP += data.p;
                }
            }
            ansMax = Math.max(ansMax, sumP + rec(fromH + h));
        }

        memo[fromH] = ansMax;
        return ansMax;
    }

    public long sellingWood(int m, int n, int[][] prices) {
        listArr = new ArrayList[m + 1];
        this.maxH = m;
        this.maxW = n;

        for (int[] price : prices) {
            int h = price[0];
            int w = price[1];
            int p = price[2];
            if (listArr[h] == null) {
                listArr[h] = new ArrayList<>();
            }
            listArr[h].add(new Data(h, w, p));
        }

        for (int i = 1; i <= m; i++) {
            List<Data> list = listArr[i];
            if (list != null) {
                Collections.sort(list, new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return Double.compare(o2.p / o2.w, o1.p / o1.w);
                    }
                });
            }
        }

        memo = new long[maxH + 1];
        Arrays.fill(memo, -1);
        return rec(1);
    }

    public static void main(String[] args) {
//        System.out.println(new D().sellingWood(3, 5, new int[][]{
//                {1,4,2},{2,2,7},{2,1,3}
//        }));

//        9
//        7
//                [[4,3,2],[5,3,16],[4,4,18],[8,7,6]]

        System.out.println(new D().sellingWood(9, 7, new int[][]{
                {4,3,2},{5,3,16},{4,4,18},{8,7,6}
        }));
    }

}
