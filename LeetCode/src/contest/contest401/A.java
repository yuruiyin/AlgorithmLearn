package contest.contest401;

public class A {

    public int numberOfChild(int n, int k) {
        int cur = 0;
        boolean isRight = true;
        while ((k--) > 0) {
            if (isRight) {
                cur++;
                if (cur == n - 1) {
                    isRight = false;
                }
            } else {
                cur--;
                if (cur == 0) {
                    isRight = true;
                }
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
