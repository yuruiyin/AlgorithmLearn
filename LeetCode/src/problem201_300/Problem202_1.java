package problem201_300;

public class Problem202_1 {

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        int[] visited = new int[730];

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

            if (visited[sum] == 1) {
                return false;
            }

            visited[sum] = 1;
            n = sum;
        }
    }


}
