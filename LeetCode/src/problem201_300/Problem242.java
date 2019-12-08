package problem201_300;

public class Problem242 {

    private int[] getCount(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }

    public boolean isAnagram(String s, String t) {
        int[] countS = getCount(s);
        int[] countT = getCount(t);

        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) {
                return false;
            }
        }

        return true;
    }

}
