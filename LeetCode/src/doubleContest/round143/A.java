package doubleContest.round143;

public class A {

    public int smallestNumber(int n, int t) {
        for (int i = n; ;i++) {
            int num = i;
            int sum = 1;
            while (num > 0) {
                sum *= num % 10;
                num /= 10;
            }
            if (sum % t == 0) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
