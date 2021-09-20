package contest.contest236;

import utils.TreeMultiSet;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/11
 */
public class D_1 {

    class MKAverage {

        private static final int MAX = 100001;

        private int m;
        private int k;
        private int[] arr;
        private int size = 0;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            arr = new int[MAX];
        }

        public void addElement(int num) {
            arr[size] = num;
            size++;
        }

        public int calculateMKAverage() {
            if (size < m) {
                return -1;
            }

            int[] tmpArr = new int[m];
            int idx = 0;
            for (int i = size - m; i <= size - 1; i++) {
                tmpArr[idx++] = arr[i];
            }
            Arrays.sort(tmpArr);
            long sum = 0;
            for (int i = k; i < m - k; i++) {
                sum += tmpArr[i];
            }
            return (int) (sum / (m - 2 * k));
        }
    }

    public static void main(String[] args) {
//        System.out.println("1");
        System.out.println(Math.round(0.5));
        System.out.println(Math.round(0.4));
    }

}
