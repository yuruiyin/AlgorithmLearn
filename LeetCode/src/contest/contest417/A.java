package contest.contest417;

public class A {

    private char nextChar(char c) {
        return c == 'z' ? 'a' : (char) (c + 1);
    }

    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while (sb.length() < k) {
            int len = sb.length();
            for (int i = 0; i < len; i++) {
                sb.append(nextChar(sb.charAt(i)));
            }
        }
        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
