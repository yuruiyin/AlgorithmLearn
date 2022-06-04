package contest.contest294;

public class A {

    public int percentageLetter(String s, char letter) {
        int[] countArr = new int[26];
        int len = s.length();
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return count * 100 / len;
    }

    public static void main(String[] args) {
        System.out.println("hello ");
    }

}
