package problem201_300;

import java.util.HashSet;
import java.util.Set;

public class Problem202 {

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();

        while (true) {
            int sum = 0;
            while (n > 0) {
                int lowestBit = n % 10;
                sum += lowestBit * lowestBit;
                n /= 10;
            }

            if (sum == 1) {
                return true;
            }

            if (visited.contains(sum)) {
                return false;
            }

            visited.add(sum);
            n = sum;
        }
    }

}
