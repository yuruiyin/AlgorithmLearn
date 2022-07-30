package contest.contest303;

public class A {

    public char repeatedCharacter(String s) {
        char[] arr = s.toCharArray();
        int[] countArr = new int[26];
        for (char c : arr) {
            countArr[c - 'a']++;
            if (countArr[c - 'a'] == 2) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println("hell");
    }

}
