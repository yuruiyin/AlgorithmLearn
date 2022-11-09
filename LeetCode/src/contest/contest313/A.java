package contest.contest313;

public class A {

    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int i = 1;i <= Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
