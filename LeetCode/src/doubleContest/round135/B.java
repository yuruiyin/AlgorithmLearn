package doubleContest.round135;

public class B {

    public int minimumLength(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] countArr = new int[26];
        for (char c : arr) {
            countArr[c - 'a']++;
        }

        int ans = 0;
        for (int count : countArr) {
            if (count < 3) {
                ans += count;
                continue;
            }
            ans += count % 2 == 0 ? 2 : 1;
        }
        return ans;
    }

}
