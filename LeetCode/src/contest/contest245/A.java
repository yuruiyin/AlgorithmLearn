package contest.contest245;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/13
 */
public class A {

    public boolean makeEqual(String[] words) {
        int[] countArr = new int[26];
        for (String word : words) {
            char[] arr = word.toCharArray();
            for (char c : arr) {
                countArr[c - 'a']++;
            }
        }

        int len = words.length;
        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0 && countArr[i] % len != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
