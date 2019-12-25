package problem501_600;

public class Problem507 {

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1;
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;

                if (sum > num) {
                    return false;
                }
            }
        }

        return sum == num;
    }

}
