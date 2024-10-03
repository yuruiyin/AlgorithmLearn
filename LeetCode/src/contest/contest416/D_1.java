package contest.contest416;

public class D_1 {

    public long validSubstringCount(String word1, String word2) {
        int[] countArr = new int[26];
        for (char c : word2.toCharArray()) {
            countArr[c - 'a']++;
        }

        char[] arr1 = word1.toCharArray();
        int n = arr1.length;
        int sum = 0;
        for (int count: countArr) {
            if (count > 0) {
                sum++;
            }
        }

        long ans = 0;
        int l = 0;
        int r = 0;
        while (l < n) {
            while (r < n && sum > 0) {
                countArr[arr1[r] - 'a']--;
                if (countArr[arr1[r] - 'a'] == 0) {
                    sum--;
                }
                r++;
            }

            if (sum == 0) {
                ans += n - r + 1;
            }
            if (countArr[arr1[l] - 'a'] == 0) {
                sum++;
            }
            countArr[arr1[l] - 'a']++;
            ++l;
        }

        return ans;
    }

}
