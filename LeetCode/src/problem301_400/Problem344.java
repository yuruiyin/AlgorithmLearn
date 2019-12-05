package problem301_400;

public class Problem344 {

    public void reverseString(char[] s) {
        int len = s.length;
        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            char tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }
    }

}
