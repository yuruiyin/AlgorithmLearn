package contest.contest282;

public class B {

    public int minSteps(String s, String t) {
        int[] countArr1 = new int[26];
        int[] countArr2 = new int[26];
        for (char c: s.toCharArray()) {
            countArr1[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            countArr2[c - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(countArr1[i] - countArr2[i]);
        }
        return ans;
    }

}
