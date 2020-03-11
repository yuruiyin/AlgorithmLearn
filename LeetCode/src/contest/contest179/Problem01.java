package contest.contest179;

public class Problem01 {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        char c1 = 'a';
        char c2 = 'b';
        if (n % 2 == 0) {
            sb.append(c1);
            n--;
            while ((n--) > 0) {
                sb.append(c2);
            }
        } else {
            if (n == 1) {
                return "a";
            }
            sb.append('c');
            sb.append(c1);
            n -= 2;
            while ((n--) > 0) {
                sb.append(c2);
            }
        }

        return sb.toString();
    }

}
