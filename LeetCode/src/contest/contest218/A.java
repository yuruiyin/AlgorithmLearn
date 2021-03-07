package contest.contest218;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/6
 */
public class A {

    public String interpret(String command) {
        String ans = command.replace("()", "o");
        ans = ans.replace("(al)", "al");
        return ans;
    }

}
