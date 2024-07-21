package doubleContest.round135;

public class A {

    public String losingPlayer(int x, int y) {
        boolean isAlice = true;
        if (!(x >= 1 && y >= 4)) {
            return "Bob";
        }

        while (x >= 1 && y >= 4) {
            x--;
            y -= 4;
            isAlice = !isAlice;
        }
        return isAlice ? "Bob" : "Alice";
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
