package contest.contest258;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/12
 */
public class A {

    public String reversePrefix(String word, char ch) {
        int to = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                to = i;
                break;
            }
        }

        if (to == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(word, 0, to + 1);
        return sb.reverse().toString() + word.substring(to + 1);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
