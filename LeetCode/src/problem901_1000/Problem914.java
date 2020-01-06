package problem901_1000;

public class Problem914 {

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }

        int max = 0;
        for (int num : deck) {
            max = Math.max(max, num);
        }

        int[] countArr = new int[max+1];
        for (int num: deck) {
            countArr[num]++;
        }

        int gcd = -1;
        for (int i = 0; i <= max; i++) {
            if (countArr[i] == 1) {
                return false;
            }

            if (gcd == -1) {
                gcd = countArr[i];
            } else {
                gcd = gcd(gcd, countArr[i]);
                if (gcd == 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
