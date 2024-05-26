package contest.contest357;

public class A {

    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char c: arr) {
            if (c != 'i') {
                sb.append(c);
            } else {
                sb.reverse();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
