package contest.contest190;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/24
 */
public class A {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (word.startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }

}
