package doubleContest.round134;

public class A {

    public int numberOfAlternatingGroups(int[] colors) {
        int len = colors.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (colors[i] != colors[(i - 1 + len) % len] && colors[i] != colors[(i + 1) % len]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
