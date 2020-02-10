package problem701_800;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// TLE
public class Problem710 {

    class Solution {

        private Set<Integer> set;
        private int N;
        private Random random;

        public Solution(int N, int[] blacklist) {
            this.N = N;
            set = new HashSet<>();
            for (int b : blacklist) {
                set.add(b);
            }
            random = new Random();
        }

        public int pick() {
            int rand = random.nextInt(N);
            while (set.contains(rand)) {
                rand = random.nextInt(N);
            }

            return rand;
        }
    }

}
