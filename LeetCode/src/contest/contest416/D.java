package contest.contest416;

public class D {

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
        int l = 0;
        int r = 0;

        boolean isFound = false;
        while (r < len1) {
            countArr1[arr1[r] - 'a']++;
            r++;
            if (isOk(countArr1, countArr2)) {
                isFound = true;
                ans += len1 - r + 1;
                break;
            }
        }

        if (!isFound) {
            return 0;
        }

        int missIdx = -1;
        while (l < r) {
            int idx = arr1[l] - 'a';
            countArr1[idx]--;
            l++;
            if (countArr1[idx] >= countArr2[idx]) {
                ans += len1 - r + 1;
            } else {
                missIdx = idx;
                break;
            }
        }

        while (l <= r) {
            boolean isFound1 = false;
            while (r < len1) {
                int idx = arr1[r] - 'a';
                countArr1[idx]++;
                r++;
                if (idx == missIdx) {
                    isFound1 = true;
                    ans += len1 - r + 1;
                    break;
                }
            }

            if (!isFound1) {
                break;
            }

            while (l < r) {
                int idx = arr1[l] - 'a';
                countArr1[idx]--;
                l++;
                if (countArr1[idx] >= countArr2[idx]) {
                    ans += len1 - r + 1;
                } else {
                    missIdx = idx;
                    break;
                }
            }
        }

        return ans;
    }

}
