package problem301_400;

public class Problem342_1 {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        if ((num & (num - 1)) != 0) {
            return false;
        }

        if ((num & 0x55555555) == num) {
            return true;
        }

        return false;
    }

}
