package doubleContest.round23;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class B {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        if (s.length() == k) {
            return true;
        }

        int[] countArr = new int[26];
        for (char c: s.toCharArray()) {
            countArr[c - 'a']++;
        }

        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (countArr[i] % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }

}
