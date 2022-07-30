package contest.contest298;

public class A {

    public String greatestLetter(String s) {
        char[] arr = s.toCharArray();
        char max = 0;
        boolean[] lowerArr = new boolean[26];
        boolean[] upperArr = new boolean[26];
        for (char c : arr) {
            if (Character.isLowerCase(c)) {
                lowerArr[c - 'a'] = true;
            } else {
                upperArr[c - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lowerArr[i] && upperArr[i]) {
                max = (char) (i + 'A');
            }
        }
        return max == 0 ? "" : String.valueOf(max);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
