package contest.contest236;

import utils.TreeMultiSet;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/11
 */
public class D {

    class MKAverage {

        private static final int MAX = 100001;

        private int m;
        private int k;
        private int[] arr;
        private int size = 0;
        private TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet<>();

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            arr = new int[MAX];
        }

        public void addElement(int num) {
            if (treeMultiSet.size() == m) {
                treeMultiSet.remove(arr[size - m]);
            }
            arr[size] = num;
            size++;
            treeMultiSet.add(num);
        }

        public int calculateMKAverage() {
            if (size < m) {
                return -1;
            }

            int[] tmpArr = new int[m];
            int idx = 0;
//            TreeMultiSet<Integer> copySet = new TreeMultiSet<>(treeMultiSet);
            for (Integer num : treeMultiSet) {
                tmpArr[idx++] = num;
            }

            long[] preSumArr = new long[m];
            preSumArr[0] = tmpArr[0];
            for (int i = 1; i < m; i++) {
                preSumArr[i] = preSumArr[i-1] + tmpArr[i];
            }

            int from = k;
            int to = m - k - 1;

            long sum = preSumArr[to] - (from == 0 ? 0 : preSumArr[from - 1]);
            return (int) (sum / (to - from + 1));
        }
    }

    public static void main(String[] args) {
//        System.out.println("1");
        System.out.println(Math.round(0.5));
        System.out.println(Math.round(0.4));
    }

}
