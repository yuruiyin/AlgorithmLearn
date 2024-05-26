package contest.contest394;

public class A {

    public int numberOfSpecialChars(String word) {
        char[] arr = word.toCharArray();
        boolean[] big = new boolean[26];
        boolean[] small = new boolean[26];
        for (char c: arr) {
            if (Character.isLowerCase(c)) {
                small[c - 'a'] = true;
            } else {
                big[c - 'A'] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (big[i] && small[i]) {
                ans++;
            }
        }
        return ans;
    }

}
