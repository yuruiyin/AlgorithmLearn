package problem1101_1200;

public class Problem1180 {

    public int countLetters(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) == s.charAt(j-1)) {
                    count++;
                } else {
                    break;
                }
            }
            ans += count;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1180().countLetters("aaaba"));
        System.out.println(new Problem1180().countLetters("aaaaaaaaaa"));
    }

}
