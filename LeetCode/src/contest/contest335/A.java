package contest.contest335;

public class A {

    public int passThePillow(int n, int time) {
        int cur = 1;
        boolean right = true;
        for (int i = 1; i <= time; i++) {
            if (cur == n) {
                cur = n - 1;
                right = false;
            } else if (cur == 1) {
                right = true;
                cur = cur + 1;
            } else {
                if (right) {
                    cur++;
                } else {
                    cur--;
                }
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
