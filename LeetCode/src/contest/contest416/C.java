package contest.contest416;

public class C {

    private boolean isOk(int[] countArr1, int[] countArr2) {
        for (int i = 0; i < 26; i++) {
            if (countArr1[i] < countArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public long validSubstringCount(String word1, String word2) {
        int[] countArr2 = new int[26];
        for (char c : word2.toCharArray()) {
            countArr2[c - 'a']++;
        }

        char[] arr1 = word1.toCharArray();
        int len1 = arr1.length;
        int[] countArr1 = new int[26];

        long ans = 0;
        int preR = 0;
        int l = 0;
        while (l < len1) {
            boolean isFound = false;
            for (int r = preR; r < len1; r++) {
                countArr1[arr1[r] - 'a']++;
                if (isOk(countArr1, countArr2)) {
                    ans += (len1 - r);
                    preR = r;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                break;
            }

            int nextL;
            for (nextL = l + 1; nextL <= preR; nextL++) {
                countArr1[arr1[nextL - 1] - 'a']--;
                if (isOk(countArr1, countArr2)) {
                    ans += (len1 - preR);
                    continue;
                }
                break;
            }

            preR++;
            l = nextL;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().validSubstringCount("abcabc", "abc"));
    }

}
