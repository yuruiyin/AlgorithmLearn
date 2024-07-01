package contest.contest404;

public class A {

    private int getH(boolean isRed, int red, int blue) {
        int h = 0;
        while (red > 0 || blue > 0) {
            if (isRed) {
                if (blue >= h + 1) {
                    h++;
                    blue -= h;
                    isRed = false;
                } else {
                    break;
                }
            } else {
                if (red >= h + 1) {
                    h++;
                    red -= h;
                    isRed = true;
                } else {
                    break;
                }
            }
        }
        return h;
    }

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(getH(true, red, blue), getH(false, red, blue));
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
