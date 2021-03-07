package contest.contest231;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/7
 */
public class A {

    public boolean checkOnesSegment(String s) {
        char[] arr = s.toCharArray();
        boolean isFound = arr[0] == '1';
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1' && arr[i-1] == '0' && isFound) {
                return false;
            }

            if (arr[i] == '1') {
                isFound = true;
            }
        }

        return true;
    }

}
