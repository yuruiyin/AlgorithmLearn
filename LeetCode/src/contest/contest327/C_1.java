package contest.contest327;

public class C_1 {

    public boolean isItPossible(String word1, String word2) {
        int[] countArr1 = new int[26];
        int[] countArr2 = new int[26];
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        for (char c : arr1) {
            countArr1[c - 'a']++;
        }

        for (char c : arr2) {
            countArr2[c - 'a']++;
        }

        int initDiffCount1 = 0;
        int initDiffCount2 = 0;
        for (int i = 0; i < 26; i++) {
            if (countArr1[i] > 0) {
                initDiffCount1++;
            }
            if (countArr2[i] > 0) {
                initDiffCount2++;
            }
        }
        boolean initSameCount = initDiffCount1 == initDiffCount2;

        if (initSameCount) {
            for (int i = 0; i < 26; i++) {
                if (countArr1[i] > 0 && countArr2[i] > 0) {
                    return true;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            int count1 = countArr1[i];
            if (count1 == 0) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    continue;
                }
                int count2 = countArr2[j];
                if (count2 == 0) {
                    continue;
                }

                // i和j交换
                int diffCount1 = initDiffCount1 + (count1 == 1 ? -1 : 0) + (countArr1[j] == 0 ? 1 : 0);
                int diffCount2 = initDiffCount2 + (count2 == 1 ? -1 : 0) + (countArr2[i] == 0 ? 1 : 0);
                if (diffCount1 == diffCount2) {
                    return true;
                }
            }
        }

        return false;
    }

}
