package contest.contest445;

public class B {

    public String smallestPalindrome(String s) {
        int[] countArr = new int[26];
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (char c: arr) {
            countArr[c - 'a']++;
        }

        char[] ansArr = new char[len];
        int curIdx = 0;
        for (int i = 0; i < 26; i++) {
            int count = countArr[i];
            char c = (char) (i + 'a');
            if (count % 2 == 1) {
                ansArr[len / 2] = c;
                count--;
            }

            int half = count / 2;
            while ((half--) > 0) {
                ansArr[curIdx] = c;
                ansArr[len - curIdx - 1] = c;
                curIdx++;
            }
        }
        return new String(ansArr);
    }

}
