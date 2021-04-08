package doubleContest.round49;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/3
 */
public class A {

    public boolean squareIsWhite(String coordinates) {
        char c1 = coordinates.charAt(0);
        char c2 = coordinates.charAt(1);

        if (((c1 - 'a' + 1) + (c2 - '0')) % 2 == 0) {
            return false;
        }

        return true;
    }

}
