package contest.contest239;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/13
 */
public class B {

    private char[] arr;
    private String s;
    private int len;

    private boolean rec(int i, long num) {
        if (i == len) {
            return true;
        }

        int nextI = -1;
        long nextNum = -1;
        for (int j = i; j < len; j++) {
            long curNum;
            try {
                curNum = Long.parseLong(s.substring(i, j + 1));
            } catch (Exception e) {
                continue;
            }

            if (curNum == num) {
                nextI = j + 1;
                nextNum = curNum - 1;
                boolean isOk = rec(nextI, nextNum);
                if (isOk) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean splitString(String s) {
        this.s = s;
        arr = s.toCharArray();
        len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            long curNum;
            try {
                curNum = Long.parseLong(s.substring(0, i + 1));
            } catch (Exception e) {
                continue;
            }
            if (curNum == 0) {
                continue;
            }

            if (rec(i + 1, curNum - 1)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new B().splitString("200100"));
    }

}
