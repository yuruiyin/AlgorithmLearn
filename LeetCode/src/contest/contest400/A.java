package contest.contest400;

public class A {

    public int minimumChairs(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        int empty = 0;
        int preE = 0;
        int preL = 0;
        for (char c: arr) {
            if (c == 'E') {
                preE++;
            } else {
                preL++;
            }
            ans = Math.max(ans, preE - preL);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
