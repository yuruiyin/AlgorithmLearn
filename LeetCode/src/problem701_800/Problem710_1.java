package problem701_800;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Problem710_1 {

    static class Solution {

        private int N;
        private Random random;
        private int[] blacklist;

        public Solution(int N, int[] blacklist) {
            this.N = N;
            this.blacklist = blacklist;
            Arrays.sort(blacklist);
            random = new Random();
        }

        public int pick() {
            int bLen = blacklist.length;
            int whiteIndex = random.nextInt(N - bLen); // 选择白名单列表的某个数

            int low = 0;
            int high = bLen - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                int leftWhiteCount = blacklist[mid] - mid; // mid左侧白名单的个数
                if (leftWhiteCount >= whiteIndex + 1) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }

            return low == high && blacklist[low] - low <= whiteIndex ? whiteIndex + low + 1 : whiteIndex;
        }
    }

    public static void main(String[] args) {
    }

}
