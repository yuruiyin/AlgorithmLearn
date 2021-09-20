package contest.contest253;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/8
 */
public class A {

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

}
