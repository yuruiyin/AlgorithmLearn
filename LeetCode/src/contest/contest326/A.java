package contest.contest326;

public class A {

    public int countDigits(int num) {
        int oldNum = num;
        int ans = 0;
        while (num > 0) {
            int bit = num % 10;
            if (oldNum % bit == 0) {
                ans++;
            }
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
