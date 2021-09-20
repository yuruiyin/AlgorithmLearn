package contest.contest243;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/30
 */
public class A {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        char[] arr1 = firstWord.toCharArray();
        char[] arr2 = secondWord.toCharArray();
        int num1 = 0;
        for (char c : arr1) {
            num1 += (c - 'a');
            num1 *= 10;
        }

        int num2 = 0;
        for (char c : arr2) {
            num2 += (c - 'a');
            num2 *= 10;
        }

        char[] targetArr = targetWord.toCharArray();
        int num = 0;
        for (char c : targetArr) {
            num += (c - 'a');
            num *= 10;
        }

        return num1 + num2 == num;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
