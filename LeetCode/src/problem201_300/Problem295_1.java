package problem201_300;

public class Problem295_1 {

    class MedianFinder {

        private int[] countArr;
        private int totalCount;

        /** initialize your data structure here. */
        public MedianFinder() {
            countArr = new int[101];
            totalCount = 0;
        }

        public void addNum(int num) {
          countArr[num]++;
          totalCount++;
        }

        public double findMedian() {
            int prevCountSum = 0;
            int prevNum = -1;
            for (int i = 0; i <= 100; i++) {
                prevCountSum += countArr[i];
                if (prevCountSum == totalCount / 2 && (totalCount & 1) == 0) {
                    prevNum = i;
                }

                if (prevCountSum > totalCount / 2) {
                    if ((totalCount & 1) == 1) {
                        return i;
                    }

                    if (prevNum != -1) {
                        return (prevNum + i) / 2.0;
                    } else {
                        return i;
                    }
                }

            }

            return -1;
        }
    }

}
