package contest.contest179;

public class Problem01_1 {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++ ) {
            sb.append('a');
        }

        if ((n & 1) == 0) {
            sb.append('b');
        } else {
            sb.append('a');
        }

        return sb.toString();
    }

}
