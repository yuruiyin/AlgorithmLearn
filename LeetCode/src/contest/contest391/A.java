package contest.contest391;

public class A {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int oldX = x;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return oldX % sum == 0 ? sum : -1;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
