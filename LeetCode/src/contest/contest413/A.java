package contest.contest413;

public class A {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int x1 = coordinate1.charAt(0);
        int y1 = coordinate1.charAt(1);
        int x2 = coordinate2.charAt(0);
        int y2 = coordinate2.charAt(1);

        return (x1 + y1) % 2 == (x2 + y2) % 2;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
