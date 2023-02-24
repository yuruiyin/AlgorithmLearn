package contest.contest329;

public class A {

    public int alternateDigitSum(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                sum += arr[i] - '0';
            } else {
                sum -= arr[i] - '0';
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
