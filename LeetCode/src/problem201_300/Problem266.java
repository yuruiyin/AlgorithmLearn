package problem201_300;

public class Problem266 {

    public boolean canPermutePalindrome(String s) {
        int[] countArr = new int[128];
        for (char c : s.toCharArray()) {
            countArr[c]++;
        }

        int oddCount = 0;
        for (int i = 0; i < 128; i++) {
            oddCount += countArr[i] & 1;
        }

        return oddCount <= 1;
    }

}
