package contest.contest379;

public class B {

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && (c != a || (d < Math.min(b, f) || d >  Math.max(b, f)))) {
            return 1;
        }

        if (b == f && (d != b || (c < Math.min(a, e) || c > Math.max(a, e)))) {
            return 1;
        }

        if (c - e == d - f && (a - e != b - f || (a < Math.min(c, e) || a > Math.max(c, e)))) {
            return 1;
        }

        if (c - e == f - d && (a - e != f - b || (a < Math.min(c, e) || a > Math.max(c, e)))) {
            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {
        System.out.println(new B().minMovesToCaptureTheQueen(7, 8, 7,7,7,3));
    }

}
