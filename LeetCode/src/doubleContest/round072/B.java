package doubleContest.round072;

public class B {

    public long[] sumOfThree(long num) {
        if (num % 3L == 0L) {
            return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
        }
        return new long[0];
    }

}
