package problem301_400;

public class Problem367 {

    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= 65536; i++) {
            if (i * i > num) {
                return false;
            }

            if (i * i == num) {
                return true;
            }
        }

        return false;
    }

}
