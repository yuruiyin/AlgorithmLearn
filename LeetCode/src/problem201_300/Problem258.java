package problem201_300;

public class Problem258 {

    public int addDigits(int num) {
        if (num / 10 == 0) {
            return num;
        }

        int nextNum = 0;
        while (num > 0) {
            nextNum += num % 10;
            num /= 10;
        }

        return addDigits(nextNum);
    }

}
