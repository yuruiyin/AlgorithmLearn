package contest.contest315;

public class C {

    private int getReverse(int num) {
        int reverseNum = 0;
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }
        return reverseNum;
    }

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + getReverse(i) == num) {
                return true;
            }
        }
        return false;
    }

}
