package doubleContest.round153;

public class A {

    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans += (26 - (c - 'a')) * (i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
