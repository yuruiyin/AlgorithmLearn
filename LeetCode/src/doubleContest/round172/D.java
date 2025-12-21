package doubleContest.round172;

public class D {

    public long lastInteger(long n) {
        long offset = 1;
        long firstNum = 1;
        long lastNum = n;
        long count = n;
        boolean isFromLeft = true;
        while (count > 1) {
            if (count % 2 == 0) {
                if (isFromLeft) {
                    lastNum = lastNum - offset;
                } else {
                    firstNum = firstNum + offset;
                }
                count /= 2;
            } else {
                count = count / 2 + 1;
            }

            offset *= 2;
            isFromLeft = !isFromLeft;
        }
        return firstNum;
    }

    public static void main(String[] args) {
        System.out.println(new D().lastInteger(8));
    }

}
