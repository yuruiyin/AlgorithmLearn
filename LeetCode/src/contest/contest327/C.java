package contest.contest327;

public class C {

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

        for (int i = 0; i < 26; i++) {
            int count1 = countArr1[i];
            if (count1 == 0) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                int count2 = countArr2[j];
                if (count2 == 0) {
                    continue;
                }

                int diffCount1 = 0;
                for (int k = 0; k < 26; k++) {
                    if (k == j) {
                        diffCount1++;
                    } else if (k == i) {
                        if (countArr1[i] > 1) {
                            diffCount1++;
                        }
                    } else {
                        if (countArr1[k] > 0) {
                            diffCount1++;
                        }
                    }
                }

                int diffCount2 = 0;
                for (int k = 0; k < 26; k++) {
                    if (k == i) {
                        diffCount2++;
                    } else if (k == j) {
                        if (countArr2[j] > 1) {
                            diffCount2++;
                        }
                    } else {
                        if (countArr2[k] > 0) {
                            diffCount2++;
                        }
                    }
                }

                if (diffCount1 == diffCount2) {
                    return true;
                }
            }
        }

        return false;
    }

}
