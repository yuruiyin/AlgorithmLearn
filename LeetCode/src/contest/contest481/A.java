package contest.contest481;

public class A {

    public int mirrorDistance(int n) {
        String re = new StringBuilder("" + n).reverse().toString();
        int reNum = Integer.parseInt(re);
        return Math.abs(n - reNum);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
