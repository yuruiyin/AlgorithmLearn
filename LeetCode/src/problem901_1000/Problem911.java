package problem901_1000;

public class Problem911 {

    class TopVotedCandidate {

        private int[] winArr;
        private int len;
        private int[] times;

        class Data {
            int personId;
            int count;
            Data(int personId, int count) {
                this.personId = personId;
                this.count = count;
            }
        }

        public TopVotedCandidate(int[] persons, int[] times) {
            len = persons.length;
            winArr = new int[len];
            this.times = times;

            int[] countArr = new int[len+1];
            Data maxCountData = null;
            for (int i = 0; i < len; i++) {
                countArr[persons[i]]++;
                int curPersonCount = countArr[persons[i]];

                if (maxCountData == null) {
                    maxCountData = new Data(persons[i], curPersonCount);
                    winArr[i] = persons[i];
                    continue;
                }

                if (maxCountData.personId == persons[i]) {
                    maxCountData.count++;
                    winArr[i] = maxCountData.personId;
                    continue;
                }

                // 当前personId不是最大的personcount
                if (curPersonCount >= maxCountData.count) {
                    maxCountData.count = curPersonCount;
                    maxCountData.personId = persons[i];
                    winArr[i] = persons[i];
                } else {
                    winArr[i] = maxCountData.personId;
                }

            }
        }

        private int findLastSmaller(int[] times, int target) {
            int low = 0;
            int high = len - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = times[mid];

                if (midVal <= target) {
                    if (mid == len - 1 || times[mid + 1] > target) {
                        return mid;
                    }

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;  // 不可能是-1
        }

        public int q(int t) {
            int index = findLastSmaller(times, t);
            return winArr[index];
        }
    }

}
