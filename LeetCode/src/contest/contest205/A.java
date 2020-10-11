package contest.contest205;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/6
 */
public class A {

    private char getNextChar(char c) {
        return (char) (((c - 'a' + 1) % 26) + 'a');
    }

    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        if (len == 1) {
            if (arr[0] == '?') {
                return "a";
            }
            return s;
        }

        if (arr[0] == '?') {
            arr[0] = arr[1] == '?' ? 'a' : getNextChar(arr[1]);
        }

        for (int i = 1; i < len - 1; i++) {
            if (arr[i] == '?') {
                if (arr[i + 1] == '?') {
                    arr[i] = getNextChar(arr[i - 1]);
                } else {
                    char nextChar = getNextChar(arr[i - 1]);
                    arr[i] = nextChar != arr[i + 1] ? nextChar : getNextChar(arr[i + 1]);
                }
            }
        }

        if (arr[len - 1] == '?') {
            arr[len - 1] = getNextChar(arr[len - 2]);
        }

        return new String(arr);
    }

}
