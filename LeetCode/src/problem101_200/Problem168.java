package problem101_200;

public class Problem168 {

    public String convertToTitle(int n) {
        // 26进制
        StringBuilder ansSb = new StringBuilder();
        while (n > 0) {
            int value = (n-1) % 26;
            ansSb.append((char)(value + 'A'));
            n = (n - value + 1) / 26;
        }

        return ansSb.reverse().toString();
    }

}
