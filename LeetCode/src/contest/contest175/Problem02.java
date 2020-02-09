package contest.contest175;

public class Problem02 {

    public int minSteps(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] sCountArr = new int[26];
        int[] tCountArr = new int[26];

        for (char c: sArr) {
            sCountArr[c - 'a']++;
        }

        for (char c: tArr) {
            tCountArr[c - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(sCountArr[i] - tCountArr[i]);
        }

        return ans / 2;
    }

}
