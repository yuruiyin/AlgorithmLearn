package problem301_400;

public class Problem383 {

    private int[] getCountArr(String word) {
        int[] countArr = new int[26];
        for (char c : word.toCharArray()) {
            countArr[c - 'a']++;
        }
        return countArr;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countArr1 = getCountArr(ransomNote);
        int[] countArr2 = getCountArr(magazine);

        for (int i = 0; i < 26; i++) {
            if (countArr1[i] > countArr2[i]) {
                return false;
            }
        }

        return true;
    }

}
