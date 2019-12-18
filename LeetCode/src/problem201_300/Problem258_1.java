package problem201_300;

public class Problem258_1 {

    public int addDigits(int num) {
        int latestNum = num;
        while (latestNum / 10 > 0) {
            num = latestNum;
            latestNum = 0;
            while (num > 0) {
                latestNum += num % 10;
                num /= 10;
            }
        }
        return latestNum;
    }

}
