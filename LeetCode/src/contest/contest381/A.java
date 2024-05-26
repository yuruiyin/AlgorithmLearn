package contest.contest381;

public class A {

    public int minimumPushes(String word) {
        int len = word.length();
        if (len <= 8) {
            return len;
        }
        if (len <= 16) {
            return 8 + (len - 8) * 2;
        }

        if (len <= 24) {
            return 8 + 16 + (len - 16) * 3;
        }

        return 8 + 16 + 24 + (len - 24) * 4;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
