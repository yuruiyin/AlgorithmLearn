package doubleContest.round64;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/30
 */
public class B {

    class Data {
        int s;
        int e;
        int v;
        Data(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return s == data.s && e == data.e && v == data.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, e, v);
        }
    }

    public int maxTwoEvents(int[][] events) {
        TreeSet<Data> treeSet = new TreeSet<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.v == o1.v ? o1.s - o2.s : o2.v - o1.v;
            }
        });

        List<Data> list = new ArrayList<>();
        for (int[] event : events) {
            int s = event[0];
            int e = event[1];
            int v = event[2];
            Data data = new Data(s, e, v);
            treeSet.add(data);
            list.add(data);
        }

        list.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.e - o2.e;
            }
        });

        int ansMax = 0;
        for (int i = 0; i < list.size(); i++) {
            Data cur = list.get(i);
//            treeSet.remove(cur);
            while (!treeSet.isEmpty()) {
                Data first = treeSet.first();
                if (first.s <= cur.e) {
                    treeSet.pollFirst();
                } else {
                    break;
                }
            }

            if (!treeSet.isEmpty()) {
                ansMax = Math.max(ansMax, cur.v + treeSet.first().v);
            } else {
                ansMax = Math.max(ansMax, cur.v);
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new B().maxTwoEvents(new int[][]{
                {1,3,2},{4,5,2},{2,4,3}
        }));
    }

}
