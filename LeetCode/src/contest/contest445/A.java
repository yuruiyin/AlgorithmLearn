package contest.contest445;

public class A {

    public int findClosest(int x, int y, int z) {
        int diff = Math.abs(x - z) - Math.abs(y - z);
        if (diff == 0) {
            return 0;
        } else if (diff > 0) {
            return 2;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
