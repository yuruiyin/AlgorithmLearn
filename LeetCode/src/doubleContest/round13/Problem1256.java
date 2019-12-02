package doubleContest.round13;

public class Problem1256 {

    private StringBuilder convert(int num) {
        if (num == 0) {
            return new StringBuilder("0");
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }

        return sb.reverse();
    }

    public String encode(int num) {
        // 加1取后n-1位
        num++;
        return convert(num).substring(1);
    }
    
    public static void main(String[] args) {

    }
    
}
