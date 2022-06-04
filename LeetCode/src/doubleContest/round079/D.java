package doubleContest.round079;

import utils.TreeMultiSet;

import java.util.Arrays;

public class D {

    static class BookMyShow {

        long[] leftCountArr;
        int from = 0;
        private int rowCount;
        private int colCount;

        public BookMyShow(int n, int m) {
            this.rowCount = n;
            this.colCount = m;
            leftCountArr = new long[n];
            Arrays.fill(leftCountArr, m);
        }

        public int[] gather(int k, int maxRow) {
            if (k > colCount) {
                return new int[0];
            }
            boolean hasNotZero = false;
            for (int r = from; r <= maxRow && r < rowCount; r++) {
                if (leftCountArr[r] > 0) {
                    hasNotZero = true;
                }
                if (leftCountArr[r] >= k) {
                    long c = colCount - leftCountArr[r];
                    leftCountArr[r] -= k;
                    if (leftCountArr[r] == 0 && !hasNotZero) {
                        from = r + 1;
                    }



                    return new int[]{r, (int) c};
                } else if (leftCountArr[r] == 0 && !hasNotZero) {
                    from = r + 1;
                }
            }
            return new int[0];
        }

        public boolean scatter(int k, int maxRow) {
            long leftSum = 0;
            int targetR = -1;
            for (int r = from; r <= maxRow && r < rowCount; r++) {
                leftSum += leftCountArr[r];
                if (leftSum >= k) {
                    // 够了
                    targetR = r;
                    break;
                }
            }
            if (targetR == -1) {
                return false;
            }
            if (leftSum == k) {
                from = targetR + 1;
            } else {
                // leftSum  > k
                from = targetR;
                long preLeftSum = leftSum - leftCountArr[targetR];
                leftCountArr[targetR] -= (k - preLeftSum);
            }
            return true;
        }

        private static void print(int[] res) {
            if (res.length != 2) {
                System.out.println("[]");
            } else {
                System.out.println(res[0] + ", " + res[1]);
            }
        }

//        ["BookMyShow","gather","scatter","gather","gather","gather"]
//                [[5,9],[10,1],[3,3],[9,1],[10,2],[2,0]]
        public static void main(String[] args) {
            BookMyShow bookMyShow = new BookMyShow(5, 9);
            int[] res1 = bookMyShow.gather(10, 1);
            print(res1);
            System.out.println(bookMyShow.scatter(3, 3));
            int[] res2 = bookMyShow.gather(9, 1);
            print(res2);
            int[] res3 = bookMyShow.gather(10, 2);
            print(res3);
            int[] res4 = bookMyShow.gather(2, 0);
            print(res4);
        }
    }

}
