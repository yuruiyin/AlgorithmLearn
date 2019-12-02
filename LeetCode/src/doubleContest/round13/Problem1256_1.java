package doubleContest.round13;

public class Problem1256_1 {

    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }

}
