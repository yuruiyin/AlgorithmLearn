package lcci;

public class Lcci0102_1 {

    private int[] getCountArr(String s) {
        int[] countArr = new int[128];
        for (char c : s.toCharArray()) {
            countArr[c]++;
        }
        return countArr;
    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] countArr1 = getCountArr(s1);
        int[] countArr2 = getCountArr(s2);

        for (int i = 0; i < 128; i++) {
            if (countArr1[i] != countArr2[i]) {
                return false;
            }
        }

        return true;
    }
}
