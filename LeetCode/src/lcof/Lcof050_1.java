package lcof;

public class Lcof050_1 {

    public char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        if (len == 0) {
            return ' ';
        }

        int[] countArr = new int[128];
        for (char c : arr) {
            countArr[c]++;
        }

        for (char c: arr) {
            if (countArr[c] == 1) {
                return c;
            }
        }

        return ' ';
    }

}
